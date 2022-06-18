package za.ac.cput.controller;
/*
 * @Author Reanetsi Sholoko
 * @Student number: 218160402*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Name;
import za.ac.cput.factory.NameFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NameControllerTest {

    @Autowired
    private NameController controller;
    @Autowired private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/name";
    private static Name name;

    @Order(0)
    @Test
    void init() {
        assertNotNull(controller);
        name = NameFactory.createName("John","Killer","Doe");
        assertNotNull(name);
    }

    @Order(1)
    @Test
    void save(){
        System.out.println(baseUrl);
        String url = baseUrl + "/create";
        System.out.println(url);
        ResponseEntity<Name> response = this.restTemplate
                .postForEntity(url, this.name, Name.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read(){
        String url = baseUrl + "/read/" + this.name.getFirstName();
        System.out.println(url);
        ResponseEntity<Name[]> response =
                this.restTemplate.getForEntity(url, Name[].class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void delete(){
        String url = baseUrl + "/delete";
        System.out.println(url);
        ResponseEntity<Name> response = this.restTemplate
                .postForEntity(url, this.name, Name.class);
        this.restTemplate.delete(url);
    }

    @Order(3)
    @Test
    void getAll(){
        String url = baseUrl + "/getall";
        System.out.println(url);
        ResponseEntity<Name[]> response =
                this.restTemplate.getForEntity(url, Name[].class);
        System.out.println(response.getBody());
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }

}

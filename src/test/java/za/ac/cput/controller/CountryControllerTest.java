/*CountryControllerTest.java
 Entity CountryControllerTest
 Author: Kululo Mangcunyana (219387117)
 Date: 18 June 2022
 */

package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.MethodOrderer;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.TestMethodOrder;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.boot.test.web.client.TestRestTemplate;
        import org.springframework.boot.web.server.LocalServerPort;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import za.ac.cput.factory.CountryFactory;
        import za.ac.cput.domain.Country;

        import java.util.Arrays;

        import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class CountryControllerTest {

    @LocalServerPort
    private int port;

    @Autowired private CountryController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Country country = CountryFactory.build("id","name");
    private  String baseUrl;


    @BeforeEach
    void setUp() {
        this.country=CountryFactory.build("id","name");
        this.baseUrl= "http://localhost:"+this.port+"/school/country/";

    }

    @Test
    void a_save(){
        String url= baseUrl+"save";
        System.out.println(url);
        ResponseEntity<Country> response= this.restTemplate.postForEntity(url,this.country,Country.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())

        );
    }

    @Test
    void b_read() {
        String url= baseUrl+"read/"+this.country.getId();
        System.out.println(url);
        ResponseEntity<Country> response= this.restTemplate.getForEntity(url,Country.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK,response.getStatusCode())
        );

    }

    @Test
    void d_delete() {
        String url= baseUrl+"delete/"+this.country.getId();
        this.restTemplate.delete(url);
    }

    @Test
    void c_findAll() {
        String url=baseUrl+"all";
        System.out.println(url);
        ResponseEntity<Country[]> response= this.restTemplate.getForEntity(url,Country[].class);
        System.out.println(Arrays.asList(response.getBody()));

        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode())//,
                // () -> assertTrue(response.getBody().length=0)


        );


    }
}
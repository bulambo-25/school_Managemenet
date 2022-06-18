/*
 * @Author Reanetsi Sholoko
 * @Student number: 218160402*/
package za.ac.cput.controller;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.City;
import za.ac.cput.factory.CityFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
@Slf4j
class CityControllerTest {

    @LocalServerPort
    private  int port;
    @Autowired
    private CityController controller;

    @Autowired
    private TestRestTemplate restTemplate;
    private City city;
    private String baseURL;

    @BeforeEach
    void setUp() {
        this.city = CityFactory.createCity("K234", "Bush-Bush", "RT5","Uganda");
        this.baseURL="http://localhost:"+ this.port+"/school_Management/City";
        a_save();
    }
    @Test
    void a_save() {
        String url=baseURL+"/save";
        ResponseEntity<City> response=this.restTemplate
                .postForEntity(url,this.city,City.class);
        log.info("Error: ",response);
        System.out.println(response.toString());
        assertNotNull(response.getBody());
    }
    @Test
    void b_read() {
        String url= baseURL+ "/read/"+ city.getId();
        ResponseEntity<City> response=this.restTemplate.getForEntity(url,City.class);
        log.info("Error",response);

        assertNotNull(response);
    }
    @Test
    void d_delete() {
        String url=baseURL+ "/delete";
        this.restTemplate
                .delete(url,city);

    }
    @Test
    void c_findALL() {
        String url=baseURL+"/getall";
        ResponseEntity<City[]> response=this.restTemplate.getForEntity(url,City[].class);
        System.out.println("Contains---- "+response.toString());

        assertTrue(response.hasBody());
    }

}

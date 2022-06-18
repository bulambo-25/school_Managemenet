package za.ac.cput.controller;

/*Martinez Safari 219325332
	  ADP3 - June Assessment 2022
	  School Management System
 */

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
@Slf4j
class AddressControllerTest {
    @LocalServerPort
    private  int port;
    @Autowired
    private AddressController controller;

    @Autowired
    private TestRestTemplate restTemplate;
    private Address Address;
    private String baseURL;

    @BeforeEach
    void setUp() {
        this.Address= AddressFactory.createAddress("002345",
                "05","15","Weenen",5678,"+27","Cape Town",
                "c876","South Africa");
        this.baseURL="http://localhost:"+ this.port+"/school_Management/employeeAddress/";
        a_save();
    }
    @Test
    void a_save() {
        String url=baseURL+"save_Address";
        ResponseEntity<Address> response=this.restTemplate
                .postForEntity(url,this.Address,Address.class);
        log.info("Error: ",response);
        System.out.println(response);
        assertNotNull(response.getBody());
    }
    @Test
    void b_read() {
        String url= baseURL+ "readAddress/"+ Address.getStreetNumber();
        ResponseEntity<Address> response=this.restTemplate.getForEntity(url,Address.class);
        log.info("Erroe",response);

        assertNotNull(response);
    }
    @Test
    void d_delete() {
        String url=baseURL+ "deleteEmployeeAddress/{empID}";
        this.restTemplate
                .delete(url,Address);

    }
    @Test
    void c_findALL() {
        String url=baseURL+"getAllAddresses";
        ResponseEntity<Address[]> response=this.restTemplate.getForEntity(url,Address[].class);
        System.out.println("Contains "+response.toString());

        assertTrue(response.hasBody());
    }

}
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
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.factory.EmployeeAddressFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
@Slf4j
class EmployeeAddressControllerTest {
    @LocalServerPort
    private  int port;
    @Autowired
    private EmployeeAddressController controller;

    @Autowired
    private TestRestTemplate restTemplate;
    private EmployeeAddress employeeAddress;
    private String baseURL;

    @BeforeEach
    void setUp() {
        this.employeeAddress= EmployeeAddressFactory.createEmployeeAddress("002345",
                "05","15","55","Weenen Road",4444,"243",
                "L'shi","+243","DRC");
        this.baseURL="http://localhost:"+ this.port+"/school_Management/employeeAddress/";
        a_save();
    }
    @Test
    void a_save() {
        String url=baseURL+"save_EmployeeAddress";
        ResponseEntity<EmployeeAddress> response=this.restTemplate
                .postForEntity(url,this.employeeAddress,EmployeeAddress.class);
        log.info("Error: ",response);
        System.out.println(response);
        assertNotNull(response.getBody());
    }
    @Test
    void b_read() {
        String url= baseURL+ "readEmployeeAddress/"+ employeeAddress.getStaffID();
        ResponseEntity<EmployeeAddress> response=this.restTemplate.getForEntity(url,EmployeeAddress.class);
        log.info("Erroe",response);

        assertNotNull(response);
    }
    @Test
    void d_delete() {
        String url=baseURL+ "deleteEmployeeAddress/{empID}";
        this.restTemplate
                .delete(url,employeeAddress);

    }
    @Test
    void c_findALL() {
        String url=baseURL+"getAllEmployeeAddresses";
        ResponseEntity<EmployeeAddress[]> response=this.restTemplate.getForEntity(url,EmployeeAddress[].class);
        System.out.println("Contains "+response.toString());

        assertTrue(response.hasBody());
    }

}
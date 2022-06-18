package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.NameFactory;

import static org.junit.jupiter.api.Assertions.*;
/*   FullName: Mutamba Prince Bulambo
      StudentNumber:220177767
	  ADP3 - June Assessment 2022
	  School Management System
 */


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    private Employee employee;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        this.employee= EmployeeFactory.BuildEmployee("220","draybulambo@gmail.com",
                NameFactory.createName("Bulambo","dray","Mutamba"));
        this.baseUrl ="http://localhost:"+this.port+"/school_Management/Employee/";
        a_save();
    }

    @Test
    @Order(2)
    public void  a_save(){
        String url= baseUrl +"save";
        ResponseEntity<Employee> saveResponse=this.restTemplate.postForEntity(url,this.employee,Employee.class);
        System.out.println("Answer"+saveResponse);
        assertNotNull(saveResponse);
    }

    @Test
    @Order(3)
    public void  b_Read(){
        String url= baseUrl +"read"+employee.getStaffId();
        ResponseEntity<Employee>readByIDResponse=this.restTemplate.getForEntity(url,Employee.class);
        assertNotNull(readByIDResponse);
    }

    @Test
    @Order(4)
    public void  c_findByEmail(){
        String url= baseUrl +"read"+employee.getEmail();
        ResponseEntity<Employee>readByIDResponse=this.restTemplate.getForEntity(url,Employee.class);
        assertNotNull(readByIDResponse);

    }
    @Test
    @Order(5)
    public void  d_findAll(){
        String url= baseUrl +"All";
        this.restTemplate.delete(url,employee);

    }
    @Test
    @Order(6)
    public void  e_deleteEmployee(){
        String url= baseUrl +"delete";
        ResponseEntity<Employee>findAllResponse=this.restTemplate.getForEntity(url,Employee.class);
        System.out.println("Answer"+findAllResponse);
        assertNotNull(findAllResponse);
    }
}
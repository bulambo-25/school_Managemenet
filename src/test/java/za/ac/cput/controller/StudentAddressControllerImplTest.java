package za.ac.cput.controller;
/*
 * Name: Taariq Khan
 * Student number: 219231141
 * ADP372S – APPLICATIONS DEVELOPMENT PRACTICE 3
 * EXAMINER: K NAIDOO
 * MODERATOR: R BURGER
 * RELEASE DATE: 09th June 2022
 * DUE DATE: 18th June 2022
 * TOTAL MARKS: 100
 * */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.StudentAddressFactory;


import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentAddressControllerImplTest
{
    @LocalServerPort
    private int port;

    @Autowired
    private StudentAddressControllerImpl controller;
    @Autowired
    TestRestTemplate restTemplate;

    Address address;
    StudentAddress studentAddress;

    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        this.address = AddressFactory.createAddress("49", "lands", "63",
                "ordan", 128,"KK#", "Bush-Bush", "RT5","Uganda");
        this.studentAddress = StudentAddressFactory
                .build("6745", address);
        ;
        this.baseUrl = "http://localhost:" + this.port + "/school/student/address/";
    }

    @Test
    @Order(1)
    void save()
    {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<StudentAddress> response = this.restTemplate
                .postForEntity(url, this.studentAddress, StudentAddress.class);
        System.out.println(response);
        assertAll
                (
                        () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                        () -> assertNotNull(response.getBody())
                );
    }

    @Test
    @Order(2)
    void read()
    {
        String url = baseUrl + "read/" + this.studentAddress.getStudentId();
        System.out.println(url);
        ResponseEntity<StudentAddress> response = this.restTemplate.getForEntity(url, StudentAddress.class);
        assertAll
                (
                        () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                        () -> assertNotNull(response.getBody())
                );
    }

    @Test
    @Order(3)
    void delete()
    {
        String url = baseUrl + "delete" + this.studentAddress.getStudentId();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(4)
    void findById()
    {
        String url = baseUrl + "find";
        System.out.println(url);
        ResponseEntity<StudentAddress[]> response = this.restTemplate.getForEntity(url, StudentAddress[].class);
        System.out.println(Array.getLength(response.getBody()));
        assertAll
                (
                        () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                        () -> assertNotNull(response.getBody().length == 0)
                );
    }
}

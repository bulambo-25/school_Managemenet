package za.ac.cput.controller;
/*
Farai Malone Chawora
Student Number 220145547
ADP 3 PRACTICAL Exam Assignment
Group 3
 */
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.student.Student;
import za.ac.cput.factory.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
@Slf4j
class StudentControllerTest {
    @LocalServerPort
    private  int port;
    @Autowired
    private StudentController controller;

    @Autowired
    private TestRestTemplate restTemplate;
    private Student  student;
    private String baseURL;

    @BeforeEach
    void setUp() {
            this.student= StudentFactory.build("220145547","farai@gmail.com","Farai","Malone","Mutamba");
         this.baseURL="http://localhost:"+ this.port+"/school_Management/Student/";
         a_save();
    }



    @Test
    void a_save() {
        String url=baseURL+"save";
        ResponseEntity<Student> response=this.restTemplate
                .postForEntity(url,this.student,Student.class);
        log.info("Entity Contants: ",response.toString());
     assertTrue(response.hasBody());
        assertNotNull(response.getBody());
    }

    @Test
    void b_read() {
        String url= baseURL+ "read/"+ student.getStudentID();
        ResponseEntity<Student> response=this.restTemplate.getForEntity(url,Student.class);
        System.out.println("Read"+response.toString());
      //  assertEquals(HttpStatus.OK,response.getBody());
        assertNotNull(response);
        assertTrue(response.hasBody());
    }

    @Test
    void d_delete() {
        String url=baseURL+ "delete";
        this.restTemplate
                .delete(url,student);

    }

    @Test
    void c_findALL() {
        String url=baseURL+"all";
        ResponseEntity<Student[]> response=this.restTemplate.getForEntity(url,Student[].class);
        System.out.println("Contains---- "+response.toString());
        System.out.println("Contains "+response.getBody());
        assertTrue(response.hasBody());
        assertTrue(response.getBody().length==1);

    }
}
package za.ac.cput.service.impl;
/*
Farai Malone Chawora
Student Number 220145547
ADP 3 PRACTICAL Exam Assignment
Group 3
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.student.Student;
import za.ac.cput.factory.StudentFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class StudentServiceImplTest {
  @Autowired private StudentServiceImpl studentService;
    Student student= StudentFactory.build("12344","stu@gmail.com","Malone","Prince","Mutamba");



    @Test
    void a_save() {
       Student temp=studentService.save(student);
       assertNotNull(temp);
    }

    @Test
    void b_read() {

        Optional<Student> temp=studentService.read("12344");
      assertAll(  ()->assertTrue(temp.isPresent()),
                  ()-> assertNotNull(temp)
      );
        System.out.println(temp);

    }

    @Test
    void d_delete() {
      studentService.delete(student);
        List<Student> temp=studentService.findAll();
        assertEquals(0,temp.size());


    }

    @Test
    void c_findall() {
        List<Student> temp=studentService.findAll();
        System.out.println(temp.toString());
        assertNotNull(temp);
    }
}
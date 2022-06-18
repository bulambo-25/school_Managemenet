package za.ac.cput.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.NameFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
/*    Mutamba Prince Bulambo
      220177767
	  ADP3 - June Assessment 2022
	  School Management System
 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
class EmployeeServiceTest {


    @Autowired
    private EmployeeService emplService;
    Employee employee;

    @BeforeEach
    void BeforeEachTest()
    {

        employee= EmployeeFactory.BuildEmployee("220177767","draybulambo45@gmail.com"
                , NameFactory.createName("Mutamba","Prince","Bulambo"));


    }

    @Test
    void a_save() {
        Employee employee1= this.emplService.save(employee);
        System.out.println(employee1);
        log.info("save :{}",employee1 );
        assertNotNull(employee1);
    }

    @Test
    void b_read() {

        Optional<Employee> read=this.emplService.read("220177767");
        assertNotNull(read);
        log.info("read :{}",read );
        System.out.println(read);


        ;}
    @Test
    void c_findEmployeeByEmail() {


        Optional<Employee> findByEmail = this.emplService.findByEmail("draybulambo45@gmail.com");

        assertNotNull(findByEmail);
        log.info("email :{}",findByEmail );
        System.out.println(findByEmail);

        assertAll(
                () -> assertEquals("draybulambo45@gmail.com", employee.getEmail())

        );
    }
    @Test
    void d_findall() {
        List<Employee> employees= this.emplService.findALL();
        System.out.println(employees.toString());
        assertNotNull(employees);

    }
    @Test
    void e_delete() {


        this.emplService.delete(this.employee);
        List<Employee> temp= this.emplService.findALL();
        assertEquals(0,temp.size());
        ;
    }
}
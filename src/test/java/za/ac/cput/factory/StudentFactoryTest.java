package za.ac.cput.factory;
/*
Farai Malone Chawora
Student Number 220145547
ADP 3 PRACTICAL Exam Assignment
Group 3
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.student.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {

@Test
    public void testBuild(){

        Student student=StudentFactory.build("1234567","farai@gmail.com","Farai",
                "","Chawora");
        System.out.println(student);
        assertNotNull(student);
    }
@Test
    public void testInvalidBuild(){

    Exception exception=assertThrows( IllegalArgumentException.class,()->StudentFactory.build("","farai@gmail.com","Farai",
            "","Chawora"));
    String exceptionMessage= exception.getMessage();
   assertSame(exceptionMessage ,exception.getMessage());
    System.out.println(exceptionMessage);
}



}
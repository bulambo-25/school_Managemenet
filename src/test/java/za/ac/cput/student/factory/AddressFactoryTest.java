package za.ac.cput.student.factory;
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
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.student.StudentAddressFactory;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest
{
    @Test
    public void buildWithSuccess()//test passed with student ID provided
    {
        //String unitNumber = "45";

        Address address = AddressFactory.build("45","Parklands","45","Jordan",6237);
        StudentAddress studentAddress = StudentAddressFactory.build("1234",address);
        System.out.println(studentAddress);
        assertNotNull(address);
    }
    @Test
    public void buildWithFailureError()//no student ID provided error test
    {
        Address address = AddressFactory.build("45","Parklands","23","Jordan",1237);
        Exception exception = assertThrows(IllegalArgumentException.class,()-> AddressFactory.build("","","","",2343));

        String exceptionMessage = exception.getMessage();
        System.out.print(exceptionMessage);
        assertSame("student ID is required",exceptionMessage);
    }
}
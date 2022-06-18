package za.ac.cput.factory;
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

import static org.junit.jupiter.api.Assertions.*;

class StudentAddressFactoryTest
{
    @Test
    public void buildWithSuccess()//test passed with student ID provided
    {
        Address address = AddressFactory.createAddress("45","Parklands","23",
                "Jordan",1237,"KK#", "Bush-Bush", "RT5","Uganda");
        StudentAddress studentAddress = StudentAddressFactory.build("1234",address);
        System.out.println(studentAddress);
        assertNotNull(studentAddress);
    }
    @Test
    public void buildWithFailureError()//no student ID provided error test
    {
        Address address = AddressFactory.createAddress("45","Parklands","23",
                "Jordan",1237,"KK#", "Bush-Bush", "RT5","Uganda");
        Exception exception = assertThrows(IllegalArgumentException.class,()-> StudentAddressFactory.build("",address));

        String exceptionMessage = exception.getMessage();
        System.out.print(exceptionMessage);
        assertSame("student ID is required",exceptionMessage);
    }
}
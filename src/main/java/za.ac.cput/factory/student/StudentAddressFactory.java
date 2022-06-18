package za.ac.cput.factory.student;
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
import za.ac.cput.helper.helper;
import za.ac.cput.domain.student.StudentAddress;

public class StudentAddressFactory
{
    public static StudentAddress build(String studentId, Address address)
    {
        helper.checkStringParam("studentId", studentId);
       // if(studentId == null || studentId.isEmpty())//you have to provide studentId
        //    throw new IllegalArgumentException("student ID is required");
        return new StudentAddress.Builder()
                .setStudentId(studentId)
                .setAddress(address)
                .build();
    }
}

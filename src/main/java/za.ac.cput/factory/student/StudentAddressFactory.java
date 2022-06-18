package za.ac.cput.factory.student;
/*
 * name: Taariq Khan
 * student number: 219231141
 *
 *
 *
 *
 * */
import za.ac.cput.helper.helper;
import za.ac.cput.domain.Address;
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

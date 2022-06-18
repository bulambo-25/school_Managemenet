package za.ac.cput.service.student;
/*
 * name: Taariq Khan
 * student number: 219231141
 *
 *
 *
 *
 * */
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.service.Interface.IService;

import java.util.List;

public interface StudentAddressService extends IService<StudentAddress, String>
{
    List<StudentAddress> findByStudentId(String studentId);
    void deleteById(String s);
}

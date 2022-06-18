package za.ac.cput.service.interf;
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

import za.ac.cput.domain.student.StudentAddress;

import java.util.List;

public interface StudentAddressService extends IService<StudentAddress, String>
{
    List<StudentAddress> findByStudentId(String studentId);
    void deleteById(String s);
}

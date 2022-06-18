package za.ac.cput.service.interf;
/*
Farai Malone Chawora
Student Number 220145547
ADP 3 PRACTICAL Exam Assignment
Group 3
 */
import za.ac.cput.domain.student.Student;

import java.util.List;

public interface StudentService extends IService<Student,String> {

List<Student> findAll();
void deleteById(String ID);


}

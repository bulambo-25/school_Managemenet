package za.ac.cput.repository.interf;
/*
Farai Malone Chawora
Student Number 220145547
ADP 3 PRACTICAL Exam Assignment
Group 3
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.student.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student ,String> {
    List<Student> findAllByStudentID(String Id);

}

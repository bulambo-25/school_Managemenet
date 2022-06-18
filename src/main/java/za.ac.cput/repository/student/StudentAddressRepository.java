package za.ac.cput.repository.student;
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
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.repository.Interface.IRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentAddressRepository extends JpaRepository<StudentAddress, String>
{
    List<StudentAddress> findByStudentId(String studentId);


}

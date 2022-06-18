package za.ac.cput.repository.student;
/*
 * name: Taariq Khan
 * student number: 219231141
 *
 *
 *
 *
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

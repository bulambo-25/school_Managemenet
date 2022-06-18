package za.ac.cput.repository.interf;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Employee;

import java.util.Optional;

@Repository
public interface IRepositoryEmployee extends JpaRepository<Employee, String> {
    Optional<Employee> findByEmail(@Param("email") String email);

}
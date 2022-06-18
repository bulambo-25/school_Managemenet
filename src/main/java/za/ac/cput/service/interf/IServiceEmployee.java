package za.ac.cput.service.interf;

import org.springframework.data.repository.query.Param;
import za.ac.cput.domain.Employee;

import java.util.List;
import java.util.Optional;
/*    Mutamba Prince Bulambo
      220177767
	  ADP3 - June Assessment 2022
	  School Management System
 */
public interface IServiceEmployee extends IService<Employee, String> {
    List<Employee> findALL();
     void deleteById(String id);
    Optional<Employee> findByEmail(@Param("email") String email);
}

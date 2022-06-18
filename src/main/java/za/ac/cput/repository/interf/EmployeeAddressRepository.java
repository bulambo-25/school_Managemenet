package za.ac.cput.repository.interf;

/*Martinez Safari 219325332
	  ADP3 - June Assessment 2022
	  School Management System
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.EmployeeAddress;

@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress,String> {

}

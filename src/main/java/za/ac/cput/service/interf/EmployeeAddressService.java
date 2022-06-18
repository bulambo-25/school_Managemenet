package za.ac.cput.service.interf;

/*Martinez Safari 219325332
	  ADP3 - June Assessment 2022
	  School Management System
 */

import za.ac.cput.domain.Address;
import za.ac.cput.domain.EmployeeAddress;

import java.util.List;

public interface EmployeeAddressService extends IService<EmployeeAddress,String> {
    List<EmployeeAddress> findAll();
}

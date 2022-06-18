package za.ac.cput.service.interf;

/*Martinez Safari 219325332
	  ADP3 - June Assessment 2022
	  School Management System
 */


import za.ac.cput.domain.Address;
import java.util.List;

public interface AddressService extends IService<Address,String> {
    List<Address> findAll();
}
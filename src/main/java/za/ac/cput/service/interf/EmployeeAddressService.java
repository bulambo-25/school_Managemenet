package za.ac.cput.service.interf;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.EmployeeAddress;

import java.util.List;

public interface EmployeeAddressService extends IService<EmployeeAddress,String> {
    List<EmployeeAddress> findAll();
}

package za.ac.cput.service.impl;

/*Martinez Safari 219325332
	  ADP3 - June Assessment 2022
	  School Management System
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.repository.interf.EmployeeAddressRepository;
import za.ac.cput.service.interf.EmployeeAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAddressServiceImpl implements EmployeeAddressService {

    private final EmployeeAddressRepository repository;

    public EmployeeAddressServiceImpl(EmployeeAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress) {
        return this.repository.save(employeeAddress);
    }

    @Override
    public Optional<EmployeeAddress> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(EmployeeAddress employeeAddress) {
        this.repository.delete(employeeAddress);
    }

    @Override
    public List<EmployeeAddress> findAll() {
        return this.repository.findAll();
    }
}

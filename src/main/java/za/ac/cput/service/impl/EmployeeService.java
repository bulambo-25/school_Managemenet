package za.ac.cput.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.repository.interf.IRepositoryEmployee;
import za.ac.cput.service.interf.IServiceEmployee;

import java.util.List;
import java.util.Optional;
/*    Mutamba Prince Bulambo
      220177767
	  ADP3 - June Assessment 2022
	  School Management System
 */
@Service
public class EmployeeService implements IServiceEmployee {

    private final IRepositoryEmployee repositoryEmployee;
@Autowired
    public EmployeeService(IRepositoryEmployee repositoryEmployee) {
        this.repositoryEmployee = repositoryEmployee;
    }


    @Override
    public Employee save(Employee employee) {
        String email=employee.getEmail();
        return findByEmail(email).map(employee1 -> {
            String ID=employee1.getStaffId();
            String Email=employee.getEmail();
            Name nam= employee.getName();
            Employee update = EmployeeFactory.BuildEmployee(ID, Email,nam );
            System.out.println("updated "+update);
            return this.repositoryEmployee.save(update);
        }).orElseGet(()->{
            String id=employee.getStaffId();
            String Email=employee.getEmail();
            Name nam= employee.getName();

            Employee insert = EmployeeFactory.BuildEmployee(id, Email,nam);
            System.out.println("Insert "+insert);
            return  this.repositoryEmployee.save(insert);});
    }

    @Override
    public Optional<Employee> read(String id) {
        return this.repositoryEmployee.findById(id);
    }

    @Override
    public void delete(Employee employee) {
        this.repositoryEmployee.delete(employee);

    }

    @Override
    public List<Employee> findALL() {
        return this.repositoryEmployee.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<Employee> employee=read(id);
        if(employee.isPresent())
        {
            delete(employee.get());
        }

    }

    @Override
    public Optional<Employee> findByEmail(String email) {
        return this.repositoryEmployee.findByEmail(email);
    }
}

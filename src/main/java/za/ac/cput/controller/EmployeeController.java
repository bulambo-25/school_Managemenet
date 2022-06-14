package za.ac.cput.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.impl.EmployeeService;
/*    Mutamba Prince Bulambo
      220177767
	  ADP3 - June Assessment 2022
	  School Management System
 */
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("school_Management/Employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("save")
    public ResponseEntity<Employee> save(@RequestBody @Valid Employee employee)
    {
        log.info("save request:{}",employee );
        Employee save= this.employeeService.save(employee);
        return  ResponseEntity.ok(save);
     }
     private Optional<Employee>findById(String id){
        return this.employeeService.read(id);
     }
    @GetMapping("read/{id}")
    public ResponseEntity<Employee> read(@PathVariable  String id) {
        Employee read=this.employeeService.read(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(read);
    }

    @GetMapping("findByEmail//")
    public ResponseEntity<Employee> findByEmail(@PathVariable  String email) {
        Employee read=this.employeeService.findByEmail(email).
                orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(read);
    }


    @GetMapping("All")
    public ResponseEntity<List<Employee>> findALL(){

        List<Employee> addressType= this.employeeService.findALL();
        return ResponseEntity.ok(addressType);
    }

    @DeleteMapping("delete")
    public  ResponseEntity<Void> delete(Employee employee)
    {
        this.employeeService.delete(employee);

        return  ResponseEntity.noContent().build();
    }
}

package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.service.interf.EmployeeAddressService;
//import za.ac.cput.service.imp.EmployeeAddressService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("school_Management/employeeAddress/")
@Slf4j
public class EmployeeAddressController {

    private final EmployeeAddressService employeeAddressService;

    @Autowired
    public EmployeeAddressController(EmployeeAddressService employeeAddressService) {
        this.employeeAddressService = employeeAddressService;
    }

    @PostMapping("save_EmployeeAddress")
    public ResponseEntity<EmployeeAddress> save(@Valid @RequestBody EmployeeAddress saveEmployeeAddress){
        log.info("Save request: {}",saveEmployeeAddress);

        try{
            EmployeeAddress employeeAddress = employeeAddressService.save(saveEmployeeAddress);
            return ResponseEntity.ok(employeeAddress);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("readEmployeeAddress/{empID}")
    public ResponseEntity<Optional<EmployeeAddress>> read(@PathVariable String empID){
        log.info("Read request: {}",empID);

        try{
            Optional<EmployeeAddress> readEmployeeAddress = employeeAddressService.read(empID);
            return ResponseEntity.ok(readEmployeeAddress);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("deleteEmployeeAddress/{empID}")
    public ResponseEntity<EmployeeAddress> delete(@PathVariable EmployeeAddress empID){
        log.info("Delete request: {}",empID);

        this.employeeAddressService.delete(empID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAllEmployeeAddresses")
    public ResponseEntity<List<EmployeeAddress>> getAll(){
        List<EmployeeAddress> listEmployeeAddress = this.employeeAddressService.findAll();
        return ResponseEntity.ok(listEmployeeAddress);
    }
}


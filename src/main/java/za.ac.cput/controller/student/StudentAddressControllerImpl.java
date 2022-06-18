package za.ac.cput.controller.student;
/*
* name: Taariq Khan
* student number: 219231141
*
*
*
*
* */
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
//import za.ac.cput.api.StudentAddressApi;
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.service.student.Impl.StudentAddressServiceImpl;
import za.ac.cput.service.student.StudentAddressService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("school/student/address/") //  http://localhost:8080/school/student/address/save
@Slf4j //call the log
public class StudentAddressControllerImpl
{

    private final StudentAddressService studentAddressService;

    //StudentAddressService studentAddressService = StudentAddressServiceImpl.getService();
    @Autowired
    public StudentAddressControllerImpl(StudentAddressService studentAddressService)//Initialized in controller constructor // no need to repeat ame code line above in different methods
    {
        this.studentAddressService = studentAddressService;
    }

    @PostMapping("save")  //Sending in to server //Traffic coordination to studentAddressService
    public ResponseEntity<StudentAddress> save(@Valid @RequestBody StudentAddress studentAddress)
    {//wrapped response in response data model to be recognized
        log.info("Save request: {} ", studentAddress); //System.out.println("Save request: %s", studentAddress);
        StudentAddress save = this.studentAddressService.save(studentAddress);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{s}")
    public ResponseEntity<StudentAddress> read(@PathVariable String s)
    {//Specific response //
        log.info("Read request: {} ", s);
        StudentAddress studentAddress = this.studentAddressService.read(s) // found // def yes
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)); //not found
        return ResponseEntity.ok(studentAddress);
    }

    @DeleteMapping("delete/{s}")
    public ResponseEntity<Void> delete(@PathVariable String s)
    {
        log.info("Read request: {} ", s);
        //this.studentAddressService.read(s);
        this.studentAddressService.deleteById(s);
        return ResponseEntity.noContent().build(); //ResponseEntity builder pattern
    }

    @GetMapping("find")
    public ResponseEntity<List<StudentAddress>> findByStudentId(String studentId)
    {
        List<StudentAddress> studentAddresses = this.studentAddressService.findByStudentId(studentId);
        return ResponseEntity.ok(studentAddresses);
    }
}

package za.ac.cput.controller;
/*
Farai Malone Chawora
Student Number 220145547
ADP 3 PRACTICAL Exam Assignment
Group 3
 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.student.Student;
import za.ac.cput.service.interf.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school_Management/Student/")
@Slf4j
public class StudentController {

    private final StudentService studentService;
   @Autowired
   public StudentController(StudentService studentService){this.studentService=studentService;}

@PostMapping("save")
public ResponseEntity<Student> save(@RequestBody @Valid Student student)
{
    log.info("Save ",student);
    Student save=studentService.save(student);
    return ResponseEntity.ok(save);
}
    @GetMapping("read/{id}")
    public ResponseEntity<Student> read(@PathVariable String id) {
        Student read=studentService.read(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete")
    public  ResponseEntity<Void> delete(Student student)
    {
        this.studentService.delete(student);

        return  ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Student>> findALL(){

        List<Student> contactType= this.studentService.findAll();
        return ResponseEntity.ok(contactType);
    }
}

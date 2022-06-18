package za.ac.cput.service.impl;
/*
Farai Malone Chawora
Student Number 220145547
ADP 3 PRACTICAL Exam Assignment
Group 3
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.student.Student;

import za.ac.cput.repository.interf.StudentRepository;
import za.ac.cput.service.interf.StudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
 private final StudentRepository repository;


    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student save(Student student) {
        return this.repository.save(student);

    }

    @Override
    public Optional<Student> read(String s) {
    return this.repository.findById(s);
    }

    @Override
    public void delete(Student student) {
     this.repository.delete(student);
    }

    @Override
    public List<Student> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String ID) {

        this.repository.deleteById(ID);
    }
}

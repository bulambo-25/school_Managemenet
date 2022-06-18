package za.ac.cput.service.student.Impl;
/*
 * name: Taariq Khan
 * student number: 219231141
 *
 *
 *
 *
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.repository.student.StudentAddressRepository;
import za.ac.cput.service.student.StudentAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAddressServiceImpl implements StudentAddressService
{
    private final StudentAddressRepository repository;

    @Autowired
    public StudentAddressServiceImpl(StudentAddressRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public StudentAddress save(StudentAddress studentAddress)
    {
        return this.repository.save(studentAddress);
    }

    @Override
    public Optional<StudentAddress> read(String s)
    {
        return this.repository.findById(s);
    }

    @Override
    public void delete(StudentAddress studentAddress)
    {
        this.repository.delete(studentAddress);
    }

    @Override
    public List<StudentAddress> findByStudentId(String studentId)
    {
        return this.repository.findByStudentId(studentId);
    }

    @Override
    public void deleteById(String s)
    {
        Optional<StudentAddress> studentAddress = read(s);
        if (studentAddress.isPresent()) delete(studentAddress.get());
    }
}

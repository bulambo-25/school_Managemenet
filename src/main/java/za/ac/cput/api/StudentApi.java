package za.ac.cput.api;

/*
Farai Malone Chawora
Student Number 220145547
ADP 3 PRACTICAL Exam Assignment
Group 3
 */
import org.springframework.stereotype.Component;
import za.ac.cput.service.impl.StudentServiceImpl;
@Component
public class StudentApi {

    private final StudentServiceImpl studentService;

    public StudentApi(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }


}

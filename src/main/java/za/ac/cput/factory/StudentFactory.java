package za.ac.cput.factory;


import za.ac.cput.domain.Name;
import za.ac.cput.domain.student.Student;
import za.ac.cput.helper.Helper;

public class StudentFactory {
    /*
    Farai Malone Chawora
    Student Number 220145547
    ADP 3 PRACTICAL Exam Assignment
    Group 3
     */
public  static Student build(String studentID, String email, String firstName,String middeleName,String lastName){

    Helper.checkStringPara("StudentID",studentID);
    Helper.checkStringPara("email",email);

    Name name= NameFactory.createName(firstName,middeleName,lastName);


    return new Student.Builder().setStudentID(studentID).setEmail(Helper.IsValidEmail(email)).setName(name).build();
}

    public static void main(String[] args) {
        Student st=StudentFactory.build("11233","farai@gmail","farai","","Chawora");
        System.out.println(st.toString());
        st.getName().getLastName();
        System.out.println(st.getName().getLastName());
    }
}

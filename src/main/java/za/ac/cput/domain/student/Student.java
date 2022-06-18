package za.ac.cput.domain.student;
/*
Farai Malone Chawora
Student Number 220145547
ADP 3 PRACTICAL Exam Assignment
Group 3
 */

import za.ac.cput.domain.Name;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="student")
public class Student implements Serializable {

     @Id @NotNull
     @Column private String studentID;

    @Column private  String email;
    @Column @Embedded private Name name;

    protected Student(){}

    private Student(Builder builder){
        this.studentID= builder.studentID;
        this.email= builder.email;
        this.name=builder.name;

    }

    public String getStudentID() {
        return studentID;
    }

    public String getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentID.equals(student.studentID) && email.equals(student.email) && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, email, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", email='" + email + '\'' +
                ", First Name=" + name.getFirstName() +'\'' +" .MiddleName="+name.getMiddleName()+'\''
                +" .LastName="+ name.getLastName()+
                '}';
    }

    public static class Builder{
        private String studentID;
        private  String email;
        private Name name;

        public Builder setStudentID(String studentID) {
            this.studentID = studentID;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setName(Name name) {
            this.name = name;
            return  this;
        }

        public Builder copy(Student student){
            this.studentID = student.studentID;
            this.email = student.email;
            this.name = student.name;
            return this;
        }
        public  Student build(){
            return new Student(this);

        }


    }
}

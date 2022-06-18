package za.ac.cput.domain.student;
/*
 * Name: Taariq Khan
 * Student number: 219231141
 * ADP372S – APPLICATIONS DEVELOPMENT PRACTICE 3
 * EXAMINER: K NAIDOO
 * MODERATOR: R BURGER
 * RELEASE DATE: 09th June 2022
 * DUE DATE: 18th June 2022
 * TOTAL MARKS: 100
 * */

import za.ac.cput.domain.Address;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class StudentAddress
{
    @NotNull
    @Id
    private String studentId;
    @NotNull
    @Embedded
    public Address address; //Address is a class

    protected StudentAddress()
    {

    }

    private StudentAddress(Builder builder)
    {
        this.studentId = builder.studentId;
        this.address = builder.address;
    }

    public String getStudentId()
    {
        return studentId;
    }

    public Address getAddress()
    {
        return address;
    }


    @Override
    public String toString()
    {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' +
                ", address=" + address +
                '}';
    }

    public static class Builder
    {
        private String studentId;
        private Address address;

        public Builder setStudentId(String studentId)
        {
            this.studentId = studentId;
            return this;
        }

        public Builder setAddress(Address address)
        {
            this.address = address;
            return this;
        }

        public Builder copy(StudentAddress studentAddress)
        {
            this.studentId = studentAddress.studentId;
            this.address = studentAddress.address;
            return this;
        }

        public StudentAddress build()
        {
            return new StudentAddress(this);
        }
    }
}


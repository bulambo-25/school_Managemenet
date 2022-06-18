/*
 * @Author Reanetsi Sholoko
 * @Student number: 218160402*/
package za.ac.cput.domain;


import javax.persistence.*;
import java.io.Serializable;

public class Name implements Serializable {


    @Column
    private String firstName;
    @Column
    private String middleName;
    @Column
    private String lastName;

    private Name(Builder builder){
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
    }

    public Name() {}

    public String getFirstName() {
        return firstName;
    }


    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Name{" + "firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + '}';
    }

    public static class Builder {
        private String firstName, middleName, lastName;

        public Builder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder setMiddleName(String middleName){
            this.middleName = middleName;
            return this;
        }

        public Builder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder copy(Name name){
            this.firstName = name.firstName;
            this.middleName = name.middleName;
            this.lastName = name.lastName;
            return this;
        }

        public Name build(){
            return new Name(this);
        }
    }

    @Override
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass()) return false;
        if(this == o) return true;
        Name x = (Name) o;
        return this.firstName.equals(x.firstName) && this.middleName.equals(x.middleName) && this.lastName.equals(x.lastName);
    }

}


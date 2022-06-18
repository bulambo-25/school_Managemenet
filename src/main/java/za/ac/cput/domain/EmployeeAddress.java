package za.ac.cput.domain;
/*Martinez Safari 219325332
	  ADP3 - June Assessment 2022
	  School Management System
 */


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;
@Entity
public class EmployeeAddress {

    //Variables
    @NotNull
    @Id
    private String staffID;
    @Embedded
    private Address address;

    protected EmployeeAddress() {
    }

    //Constructor
    public EmployeeAddress(Builder builder) {
        this.staffID = builder.staffID;
        this.address = builder.address;
    }


    //Getters
    public String getStaffID() {return staffID;}

    public Address getAddress() {return address;}

    public void setAddress(Address address) {this.address = address;}

    public static class EmployeeAddressID{
        private String staffID;
        private Address address;

        public EmployeeAddressID(String staffID, Address address) {
            this.staffID = staffID;
            this.address = address;
        }

        public String getStaffID() {
            return staffID;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EmployeeAddressID that = (EmployeeAddressID) o;
            return staffID.equals(that.staffID) && address.equals(that.address);
        }

        @Override
        public int hashCode() {
            return Objects.hash(staffID, address);
        }
    }

    //Builder
    public static class Builder {

        private String staffID;
        private Address address;


        public Builder setStaffId(String staffID) {
            this.staffID = staffID;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }


        public Builder copy(EmployeeAddress employeeaddress){
            this.staffID = staffID;
            this.address = address;

            return this;
        }

        public EmployeeAddress build(){return new EmployeeAddress(this);}

    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "staffID='" + staffID + '\'' +
                ", address=" + address.toString() +'\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeAddress that = (EmployeeAddress) o;
        return staffID.equals(that.staffID) && address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffID, address);
    }
}
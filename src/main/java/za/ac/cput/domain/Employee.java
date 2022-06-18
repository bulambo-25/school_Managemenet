package za.ac.cput.domain;





import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;
/*    Mutamba Prince Bulambo
      220177767
	  ADP3 - June Assessment 2022
	  School Management System
 */
@Entity
public class Employee {


    @NotNull
    @Id
    private  String staffId;
    @NotNull
    @Column(name = "email",unique=true)
    private String email;
    @Embedded
    private Name name;

    public Employee(Builder builder)
    {
        this.staffId=builder.staffId;
        this.email=builder.email;
        this.name=builder.name;
    }
    public Employee() {

    }

    public String getStaffId() {
        return staffId;
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
        Employee employee = (Employee) o;
        return staffId.equals(employee.staffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId);
    }
    @Override
    public String toString() {
        return "employee{" +
                "staffId='" + staffId + '\'' +
                ", email='" + email + '\'' +
                ", name=" + name +
                '}';
    }

    public static class Builder {
        private String staffId;
        private String email;
        private Name name;

        public Builder setStaff(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setName(Name name) {
            this.name = name;
            return this;
        }

        public Builder Copy(Employee emp) {
            this.staffId = emp.staffId;
            this.email = emp.email;
            this.name = emp.name;

            return this;
        }

        public Employee builder()
        {
            return new Employee(this);
        }
    }
}


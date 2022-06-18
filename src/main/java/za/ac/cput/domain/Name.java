package za.ac.cput.domain;
/*
Farai Malone Chawora
Student Number 220145547
ADP 3 PRACTICAL Exam Assignment
Group 3
 */
import com.sun.istack.NotNull;

public class Name {

    @NotNull
    private String firstName;
    private String middleName;
    @NotNull
    private String lastName;

    @SuppressWarnings("unused")
    protected Name() {
    }


    public Name(Builder builder) {

        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder {
        private String firstName, middleName;
        private String lastName;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {

            this.lastName = lastName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder copy(Name name) {
            this.firstName = name.firstName;
            this.lastName = name.lastName;
            this.middleName = name.middleName;
            return this;
        }

        public Name build() {
            return new Name(this);

        }
    }
}

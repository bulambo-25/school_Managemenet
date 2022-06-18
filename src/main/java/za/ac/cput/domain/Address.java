package za.ac.cput.domain;
/*Martinez Safari 219325332
	  ADP3 - June Assessment 2022
	  School Management System
 */


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Address {

    //Variables
    private String unitNumber;
    private String complexNumber;
    @NotNull
    private String streetNumber;
    @NotNull
    private String streetName;
    @NotNull
    private int postalCode;
    @NotNull
    @Embedded
    private City city;

    protected Address() {
    }

    //Constructor
    public Address(Builder builder) {
        this.unitNumber = builder.unitNumber;
        this.complexNumber = builder.complexNumber;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.postalCode = builder.postalCode;
        this.city = builder.city;
    }


    //Getters
    public String getUnitNumber() {
        return unitNumber;
    }

    public String getComplexNumber() {
        return complexNumber;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public City getCity() {
        return city;
    }

    public static class AddressID {
        private String streetNumber;
        private String streetName;
        private int postalCode;
        private City city;

        public AddressID(String streetNumber, String streetName, int postalCode, City city) {
            this.streetNumber = streetNumber;
            this.streetName = streetName;
            this.postalCode = postalCode;
            this.city = city;
        }

        public String getStreetNumber() {
            return streetNumber;
        }

        public String getStreetName() {
            return streetName;
        }

        public int getPostalCode() {
            return postalCode;
        }

        public City getCity() {
            return city;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AddressID addressID = (AddressID) o;
            return postalCode == addressID.postalCode && streetNumber.equals(addressID.streetNumber) && streetName.equals(addressID.streetName)
                    && city.equals(addressID.city);
        }

        @Override
        public int hashCode() {
            return Objects.hash(streetNumber, streetName, postalCode, city);
        }
    }

    //Builder
    public static class Builder {

        private String unitNumber;
        private String complexNumber;
        private String streetNumber;
        private String streetName;
        private int postalCode;
        private City city;

        public Builder setUnitNumber(String unitNumber) {
            this.unitNumber = unitNumber;
            return this;
        }

        public Builder setComplexNumber(String complexNumber) {
            this.complexNumber = complexNumber;
            return this;
        }

        public Builder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setCity(City city) {
            this.city = city;
            return this;
        }

        public Builder copy(Address address) {
            this.unitNumber = address.unitNumber;
            this.complexNumber = address.complexNumber;
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.postalCode = address.postalCode;
            this.city = address.city;

            return this;
        }

        public Address build() {
            return new Address(this);
        }

    }

    @Override
    public String toString() {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", complexNumber='" + complexNumber + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", cityID=" + city.toString() + '\'' +
                // ", cityID=" + city.getId() +'\'' +
                //", CountryID=" + city.getCountry().getCountryId()+'\'' +
                // ", CountryName=" + city.getCountry().getCountryName()+'\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return postalCode == address.postalCode && streetNumber.equals(address.streetNumber)
                && streetName.equals(address.streetName) && city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetNumber, streetName, postalCode, city);
    }
}
package za.ac.cput.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NotNull
public class Address
{

    private String unitNumber;
    private String complexName;
    private String streetNumber;
    private String streetName;
    private int postalCode;
    //private City city;//City is a class

    private Address(Builder builder)
    {
        this.unitNumber = builder.unitNumber;
        this.complexName = builder.complexName;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.postalCode = builder.postalCode;
    }

    protected Address()
    {

    }

    public String getUnitNumber()
    {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber)
    {
        this.unitNumber = unitNumber;
    }

    public String getComplexName()
    {
        return complexName;
    }

    public void setComplexName(String complexName)
    {
        this.complexName = complexName;
    }

    public String getStreetNumber()
    {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber)
    {
        this.streetNumber = streetNumber;
    }

    public String getStreetName()
    {
        return streetName;
    }

    public void setStreetName(String streetName)
    {
        this.streetName = streetName;
    }

    public int getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode(int postalCode)
    {
        this.postalCode = postalCode;
    }

    @Override
    public String toString()
    {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", complexName='" + complexName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }

    public static class Builder
    {
        private String unitNumber;
        private String complexName;
        private String streetNumber;
        private String streetName;
        private int postalCode;

        public Builder setUnitNumber(String unitNumber)
        {
            this.unitNumber = unitNumber;
            return this;
        }

        public Builder setComplexName(String complexName)
        {
            this.complexName = complexName;
            return this;
        }

        public Builder setStreetNumber(String streetNumber)
        {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName)
        {
            this.streetName = streetName;
            return this;
        }

        public Builder setPostalCode(int postalCode)
        {
            this.postalCode = postalCode;
            return this;
        }

        public Builder copy(Address Address)
        {
            this.unitNumber = unitNumber;
            this.complexName = complexName;
            this.streetNumber = streetNumber;
            this.streetName = streetName;
            this.postalCode = postalCode;
            return this;
        }

        public Address build()
        {
            return new Address(this);
        }
    }
}


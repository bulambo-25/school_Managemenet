package za.ac.cput.factory;

import za.ac.cput.domain.Address;

public class AddressFactory
{
    public static Address build(String unitNumber, String complexName, String streetNumber, String streetName, Integer postalCode)
    {
        if(unitNumber.isEmpty() || unitNumber == null)//you have to provide studentId
            throw new IllegalArgumentException("unit number required");
        if(complexName.isEmpty() || complexName == null)//you have to provide studentId
            throw new IllegalArgumentException("complex name required");
        if(streetNumber.isEmpty() || streetNumber == null)//you have to provide studentId
            throw new IllegalArgumentException("street number required");
        if(streetName.isEmpty() || streetName == null)//you have to provide studentId
            throw new IllegalArgumentException("street name required");
        if(postalCode < 1000 || postalCode >9999 )//you have to provide studentId
            throw new IllegalArgumentException("Postal code required 4 digits number between 1000-9999");
        return new Address.Builder().setUnitNumber(unitNumber).setComplexName(complexName).setStreetNumber(streetNumber).setStreetName(streetName).setPostalCode(postalCode).build();

    }
}

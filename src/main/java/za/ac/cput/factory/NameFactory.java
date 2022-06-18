/*
 * @Author Reanetsi Sholoko
 * @Student number: 218160402*/
package za.ac.cput.factory;
import za.ac.cput.domain.Name;
import za.ac.cput.util.Helper;

public class NameFactory {

    public static Name createName(String firstName, String middleName, String lastName) throws IllegalArgumentException{
        if(!Helper.isValidString(firstName) || !Helper.isValidString(lastName))
            throw new IllegalArgumentException("IllegalArgumentException");
        return new Name.Builder().setFirstName(firstName).setMiddleName(middleName).setLastName(lastName).build();
    }
}



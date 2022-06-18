/*CountryFactory.java
 Entity CountryFactory
 Author: Kululo Mangcunyana (219387117)
 Date: 18 June 2022
 */

package za.ac.cput.factory;
import za.ac.cput.domain.Country;
import za.ac.cput.helper.Helper;

public class CountryFactory {



    public static Country build(String id, String name){
        if(Helper.isEmptyOrNull(id) || Helper.isEmptyOrNull(name))
            throw new IllegalArgumentException("id and/or name");
        return new Country.Builder().setId(id).setName(name).build();

    }
}

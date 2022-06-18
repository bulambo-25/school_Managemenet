package za.ac.cput.factory;

import za.ac.cput.domain.Country;
import za.ac.cput.helper.Helper;

public class CountryFactory {

    public  static Country build( String countryId, String countryName){


        Helper.checkStringPara("countryId",countryId);
        Helper.checkStringPara("countryName",countryName);
         return  new Country.Builder().setCountryId(countryId).setCountryName(countryName).build();

    }
}

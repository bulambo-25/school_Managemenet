package za.ac.cput.factory;

import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.helper.Helper;

public class CityFactory {

    public static City build(String cityID, String cityName,String countryId, String countryName){



        Helper.checkStringPara("cityID", cityID);
        Helper.checkStringPara("cityName", cityName);
        Country country=CountryFactory.build(countryId,countryName);
        return  new City.Builder().setId(cityID).setName(cityName).setCountry(country).build();


    }
}

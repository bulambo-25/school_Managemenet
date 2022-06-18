package za.ac.cput.factory;

/*Martinez Safari 219325332
	  ADP3 - June Assessment 2022
	  School Management System
 */

import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.helper.Helper;


public class AddressFactory {

    public static Address createAddress(String unitNumber, String complexNumber,
                                        String streetNumber, String streetName, int postalCode, String cityID, String cityName,String countryId, String countryName ){


        unitNumber = Helper.EmptyIfNull(unitNumber);
        complexNumber = Helper.EmptyIfNull(complexNumber);
        Helper.checkStringPara("streetNumber", streetNumber);
        Helper.checkStringPara("streetName", streetName);

        //Helper.checkStringPara("city", city);


           City city=CityFactory.createCity(cityID,cityName,countryId,countryName);

      return    new Address.Builder()
                .setUnitNumber(unitNumber)
                .setComplexNumber(complexNumber)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setPostalCode(postalCode)
                .setCity(city)
                .build();


    }

    public static Address.AddressID buildID(Address address) {
        return new Address.AddressID(address.getStreetNumber(), address.getStreetName(), address.getPostalCode(), address.getCity());
    }

    public static void main(String[] args) {

    }

}


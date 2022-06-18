package za.ac.cput.factory;
/*
 * @Author Reanetsi Sholoko
 * @Student number: 218160402*/
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;

import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {

    private static Country country = CountryFactory.build("RT5", "Uganda");

    @Test
    void createCitySuccess() throws IllegalArgumentException {
        City city = CityFactory.createCity("KK#", "Bush-Bush", "RT5","Uganda");
        assertNotNull(city);
        assertEquals("RT5", city.getCountry());
        System.out.println(country.getId());
    }

    @Test
    void createCityFail() {
        assertThrows(IllegalArgumentException.class, ()->{
            CityFactory.createCity("", "Bush-Bush", "RT5","Uganda");
        });
        System.out.println("Thrown an error as expected");
    }
}


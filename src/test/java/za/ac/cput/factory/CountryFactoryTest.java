/*CountryFactoryTest.java
 Entity CountryFactoryTest
 Author: Kululo Mangcunyana (219387117)
 Date: 18 June 2022
 */


package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Country;

import static org.junit.jupiter.api.Assertions.*;

class CountryFactoryTest {

    @Test
    void build() {
        Country country = CountryFactory.build("34","kk");
        assertNotNull(country);
        System.out.println(country.toString());
    }
}
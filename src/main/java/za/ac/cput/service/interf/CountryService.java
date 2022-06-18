/*CountryService.java
 Entity CountryService
 Author: Kululo Mangcunyana (219387117)
 Date: 18 June 2022
 */

package za.ac.cput.service.interf;

import za.ac.cput.domain.Country;

import java.util.List;

public interface CountryService extends IService<Country, String>
 {
    void delete(Country country);

    List<Country> findAll();
    void deleteById(String id);
}

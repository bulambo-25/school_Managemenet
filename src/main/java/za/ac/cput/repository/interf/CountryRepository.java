/*CountryRepository.java
 Entity CountryRepository
 Author: Kululo Mangcunyana (219387117)
 Date: 18 June 2022
 */


package za.ac.cput.repository.interf;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Country;
public interface CountryRepository extends JpaRepository<Country, String> {

    }

/*CountryRepositoryImplTest.java
 Entity CountryRepositoryImplTest
 Author: Kululo Mangcunyana (219387117)
 Date: 18 June 2022
 */

package za.ac.cput.repository.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.CountryFactory;
        import za.ac.cput.repository.interf.CountryRepository;
        import java.util.List;
        import java.util.Optional;




@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CountryRepositoryImplTest {
    @Autowired  private CountryRepository repository;
    private final Country country = CountryFactory.build("4","lho");


    @Test
    void a_save() {
        Country saved= this.repository.save(this.country);
       assertNotNull(saved);
    }

    @Test
    void b_read() {
        Optional<Country> read = this.repository.findById(this.country.getId());
        assertAll(
               () -> assertTrue(read.isPresent()),
                () -> assertNotNull(read)
        );
    }

    @Test
    void c_delete() {
        this.repository.delete(this.country);
        List<Country> countryList=this.repository.findAll();
        assertEquals(0,countryList.size());
    }

    @Test
    void d_findAll() {
        List<Country> countryList= this.repository.findAll();
        assertEquals(0,countryList.size());
    }
}

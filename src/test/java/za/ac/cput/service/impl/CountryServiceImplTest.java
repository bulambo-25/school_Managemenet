/*CountryServiceImplTest.java
 Entity CountryServiceImplTest
 Author: Kululo Mangcunyana (219387117)
 Date: 18 June 2022
 */


package za.ac.cput.service.impl;
        import org.junit.jupiter.api.MethodOrderer;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.TestMethodOrder;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import za.ac.cput.domain.Country;
        import za.ac.cput.factory.CountryFactory;
        import java.util.List;
        import java.util.Optional;
        import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CountryServiceImplTest {
    @Autowired
    private CountryServiceImpl countryService;
    Country country = CountryFactory.build("45", "likho");


    @Test
    void a_save() {
        Country co = countryService.save(country);
        assertNotNull(co);
    }

    @Test
    void b_read() {
        Optional<Country> co = countryService.read("45");
        assertAll(
                () -> assertTrue(co.isPresent()),

                () -> assertNotNull(co)

        );
        System.out.println(co);
    }

    @Test
    void d_delete() {
        countryService.delete(country);
        List<Country> co = countryService.findAll();
        assertEquals(0, co.size());
        assertNull(co);
    }

    @Test
    void c_findAll() {
        List<Country> co = countryService.findAll();
        System.out.println(co.toString());
        assertNotNull(co);
    }

}

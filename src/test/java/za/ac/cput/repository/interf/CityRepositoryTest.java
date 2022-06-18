package za.ac.cput.repository.interf;
/*
 * @Author Reanetsi Sholoko
 * @Student number: 218160402*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CityRepositoryTest {
    /*
    @Autowired
    private CityRepository repository;
    private static Country country = CountryFactory.createCountry("ZAR", "South Africa");

    @Test
    void addCity() {

        City city = CityFactory.createCity("CPT", "Cape Town", country);
        assertNotNull(repository.save(city));
        System.out.println(city.getId()+", "+city.getName()+", "+city.getCountyId());
    }

    @Test
    void findByName() {
        City c = repository.findByName("Cape Town");
        assertNotNull(c);
        System.out.println(c.getId()+", "+c.getName()+", "+c.getCountyId());
    }*/
}

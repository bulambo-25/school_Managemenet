/*CountryServiceImpl.java
 Entity CountryServiceImpl
 Author: Kululo Mangcunyana (219387117)
 Date: 18 June 2022
 */

package za.ac.cput.service.impl;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Country;
import za.ac.cput.repository.interf.CountryRepository;
import za.ac.cput.service.interf.CountryService;
import java.util.List;
import java.util.Optional;


@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {

        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(Country country) {
        return this.countryRepository.save(country);
    }

    @Override
    public Optional<Country> read(String c) {

        return this.countryRepository.findById(c);
    }


    @Override
    public void delete(Country country) {
        this.countryRepository.delete(country);
    }


    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public  void deleteById(String id){
        Optional<Country> country = read(id);
        if (country.isPresent()) delete(country.get());

    }
}
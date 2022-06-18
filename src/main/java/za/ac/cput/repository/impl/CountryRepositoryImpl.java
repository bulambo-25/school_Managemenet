/*CountryRepositoryImpl.java
 Entity CountryRepositoryImpl
 Author: Kululo Mangcunyana (219387117)
 Date: 18 June 2022
 */

package za.ac.cput.repository.impl;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Country;
import za.ac.cput.repository.interf.CountryRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public abstract class CountryRepositoryImpl implements CountryRepository {
    private final List<Country> countryList;
    private CountryRepositoryImpl() {
        this.countryList= new ArrayList<>();
    }

    public  Country save(Country country){
        Optional<Country> read =read(country.getId());
        if (read.isPresent()){
            delete(read.get());
        }
        this.countryList.add(country);
        return country;
    }
    public Optional<Country> read(String id){
        return this.countryList.stream().filter(g ->g.getId().equalsIgnoreCase(id)).findFirst();
    }
    public  void delete(Country country){ this.countryList.remove(country);}
    public List<Country> findAll(){return this.countryList;}
}

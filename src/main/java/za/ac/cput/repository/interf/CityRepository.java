/*
 * @Author Reanetsi Sholoko
 * @Student number: 218160402*/
package za.ac.cput.repository.interf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
  //  City findByName(String name);
}


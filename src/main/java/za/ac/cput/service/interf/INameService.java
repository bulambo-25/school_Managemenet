package za.ac.cput.service.interf;
import za.ac.cput.domain.Name;
import java.util.List;

public interface INameService{

    Name create(Name name);

    void delete(Name name);

    List<Name> getAll();
    List<Name> findByFirstName(String firstName);
    List<Name> findByLastName(String lastName);
}


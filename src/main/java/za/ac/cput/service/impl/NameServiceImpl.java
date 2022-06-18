
/*
 * @Author Reanetsi Sholoko
 * @Student number: 218160402*/
package za.ac.cput.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Name;
import za.ac.cput.repository.interf.NameRepository;
import za.ac.cput.service.interf.INameService;

import java.util.List;

@Service
public class NameServiceImpl  {
  /*  @Autowired
    private NameRepository repository;

    @Override
    public Name create(Name name) {
        return repository.save(name);
    }

    @Override
    public void delete(Name name) {
        repository.delete(name);
    }

    @Override
    public List<Name> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Name> findByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    @Override
    public List<Name> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }*/
}

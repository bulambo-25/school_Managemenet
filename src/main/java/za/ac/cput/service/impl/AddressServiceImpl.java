package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.repository.interf.AddressRepository;
import za.ac.cput.service.interf.AddressService;
import java.util.List;
import java.util.Optional;
import za.ac.cput.domain.Address;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    public AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address save(Address Address) {
        return this.repository.save(Address);
    }

    @Override
    public Optional<Address> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(Address Address) {
        this.repository.delete(Address);
    }

    @Override
    public List<Address> findAll() {
        return this.repository.findAll();
    }
}

/*
 * @Author Reanetsi Sholoko
 * @Student number: 218160402*/
package za.ac.cput.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.City;
import za.ac.cput.repository.interf.CityRepository;
import za.ac.cput.service.interf.ICityService;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements ICityService {

    private CityRepository repository;
    @Autowired
    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<City> findAll() {
        return this.repository.findAll();
    }

    @Override
    public City save(City city) {
        return this.repository.save(city);
    }

    @Override
    public Optional<City> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(City city) {
        this.repository.delete(city);
    }
}

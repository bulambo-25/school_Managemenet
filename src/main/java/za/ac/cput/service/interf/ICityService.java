package za.ac.cput.service.interf;

import za.ac.cput.domain.City;

import java.util.List;

public interface ICityService extends IService<City, String> {
    List<City> findAll();
}


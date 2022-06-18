package za.ac.cput.service.impl;


/*
 * @Author Reanetsi Sholoko
 * @Student number: 218160402*/import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.City;
import za.ac.cput.factory.CityFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CityServiceImplTest {
    @Autowired
    private CityServiceImpl cityService;
    City city = CityFactory.createCity("KK#",
            "Bush-Bush", "RT5","Uganda");


    @Test
    void c_findAll() {
        List<City> findAll= cityService.findAll();
        System.out.println(findAll.toString());
        assertNotNull(findAll);
    }

    @Test
    void a_save() {
        City save= cityService.save(city);
        assertNotNull(save);
    }

    @Test
    void b_read() {
        Optional<City> readOne= cityService.read("KK#");
        assertAll(  ()->assertTrue(readOne.isPresent()),
                ()-> assertNotNull(readOne)
        );
        System.out.println(readOne);
    }


    @Test
    void d_delete() {
        cityService.delete(city);
        List<City> temp= cityService.findAll();
        assertEquals(0,temp.size());
    }
}
/*
 * @Author Reanetsi Sholoko
 * @Student number: 218160402*/
package za.ac.cput.service.impl;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Name;
import za.ac.cput.factory.NameFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class NameServiceImplTest {
/*
    @Autowired
    private NameServiceImpl service;
    private Name name = NameFactory.createName("Yellow", "Hun", "Bone");

    @Test
    void a_create() {
        assertNotNull(service.create(name));
    }

    @Test
    void e_delete() {
        service.delete(name);
        assertEquals(0, service.getAll().size());
    }

    @Test
    void b_getAll() {
        assertEquals(1, service.getAll().size());
    }

    @Test
    void c_findByFirstName() {
        assertEquals("Bone", service.findByFirstName("Yellow").get(0).getLastName());
    }

    @Test
    void d_findByLastName() {
        assertEquals("Yellow", service.findByLastName("Bone").get(0).getFirstName());
    }*/
}

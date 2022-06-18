package za.ac.cput.service.impl;

/*Martinez Safari 219325332
	  ADP3 - June Assessment 2022
	  School Management System
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class AddressServiceImplTest {

    @Autowired
    private AddressServiceImpl AddressService;
    Address employeeAddress= AddressFactory.createAddress("002345",
            "05","15","Weenen",5678,"+27","Cape Town",
            "c876","South Africa");

    @Test
    void a_save() {
        Address temp= AddressService.save(employeeAddress);
        assertNotNull(temp);

    }
    @Test
    void b_read() {

        Optional<Address> temp= AddressService.read("110022");
        assertAll(
                ()->assertTrue(temp.isPresent()),
                ()-> assertNotNull(temp)
        );
        System.out.println(temp);

    }  @Test
    void d_delete() {
        AddressService.delete(employeeAddress);
        List<Address> temp= AddressService.findAll();
        assertEquals(0,temp.size());

    }

    @Test
    void c_findall() {
        List<Address> temp= AddressService.findAll();
        System.out.println(temp.toString());
        assertNotNull(temp);
    }

}
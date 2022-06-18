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
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.factory.EmployeeAddressFactory;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeAddressServiceImplTest {

    @Autowired
    private EmployeeAddressServiceImpl employeeAddressService;
    EmployeeAddress employeeAddress= EmployeeAddressFactory.createEmployeeAddress("213345",
            "2","23","43","Fame",232,"25",
            "Cape Town","+27","South Africa");

    @Test
    void a_save() {
        EmployeeAddress temp= employeeAddressService.save(employeeAddress);
        assertNotNull(temp);
    }
    @Test
    void b_read() {

        Optional<EmployeeAddress> temp= employeeAddressService.read("123455");
        assertAll(
                ()->assertTrue(temp.isPresent()),
                ()-> assertNotNull(temp)
        );
        System.out.println(temp);

    }  @Test
    void d_delete() {
        employeeAddressService.delete(employeeAddress);
        List<EmployeeAddress> temp= employeeAddressService.findAll();
        assertEquals(0,temp.size());


    }

    @Test
    void c_findall() {
        List<EmployeeAddress> temp= employeeAddressService.findAll();
        System.out.println(temp.toString());
        assertNotNull(temp);
    }

}
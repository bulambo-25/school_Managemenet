package za.ac.cput.factory;

/*Martinez Safari 219325332
	  ADP3 - June Assessment 2022
	  School Management System
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.EmployeeAddress;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest {
    @Test
    void buildWithSuccess(){

        EmployeeAddress temp=EmployeeAddressFactory.createEmployeeAddress("213345",
                "2","23","43","Fame",232,"25",
                "Cape Town","+27","South Africa");
        System.out.println(temp.toString());
        assertNotNull(temp);
    }
    @Test
    void buildWithErrors(){
        Exception exception=assertThrows( IllegalArgumentException.class,()->EmployeeAddressFactory.createEmployeeAddress("213345",
                "2","23","43","Fame",232,"25",
                "Cape Town","","South Africa"));
        String exceptionMessage= exception.getMessage();
        assertSame(exceptionMessage ,exception.getMessage());
        System.out.println(exceptionMessage);
    }
}
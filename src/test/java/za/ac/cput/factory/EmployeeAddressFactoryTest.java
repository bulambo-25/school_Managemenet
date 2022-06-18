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

        EmployeeAddress temp=EmployeeAddressFactory.createEmployeeAddress("002345",
                "05","15","55","Weenen Road",4444,"c243",
                "L'shi","+243","DRC");
        System.out.println(temp.toString());
        assertNotNull(temp);
    }
    @Test
    void buildWithErrors(){
        Exception exception=assertThrows( IllegalArgumentException.class,()->EmployeeAddressFactory.createEmployeeAddress("002345",
                "02","15","55","Weenen Road",232,"c243",
                "L'shi","","DRC"));
        String exceptionMessage= exception.getMessage();
        assertSame(exceptionMessage ,exception.getMessage());
        System.out.println(exceptionMessage);
    }
}
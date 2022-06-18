package za.ac.cput.factory;

/*Martinez Safari 219325332
	  ADP3 - June Assessment 2022
	  School Management System
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;


import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    @Test
    void buildWithSuccess(){

        Address temp=AddressFactory.createAddress("2","342","3","Fame Cresent",
                123,"435d","Cape Town ","+27","South Africa");
        System.out.println(temp.toString());
        assertNotNull(temp);
    }
    @Test
    void buildWithErrors(){
        Exception exception=assertThrows( IllegalArgumentException.class,()->AddressFactory.createAddress("2","342","3","Fame Cresent",
                123,"","Cape Town  ","+27","South Africa"));
        String exceptionMessage= exception.getMessage();
        assertSame(exceptionMessage ,exception.getMessage());
        System.out.println(exceptionMessage);
    }
}
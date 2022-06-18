package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;

import static org.junit.jupiter.api.Assertions.*;
/*    Mutamba Prince Bulambo
      220177767
	  ADP3 - June Assessment 2022
	  School Management System
 */
class EmployeeFactoryTest {

    @Test
    public void testPass()
    {
        Name name=NameFactory.createName("Dray","Prince","Mutamba");
        Employee employee= EmployeeFactory.BuildEmployee("220177767","draybulambo45@gmail.com",name);
        System.out.println(employee.toString());
        assertNotNull(employee);

    }

    @Test public void testFailed()
    {
        Name name=NameFactory.createName("Dray","Prince","Mutmba");
        Exception exception= assertThrows(IllegalArgumentException.class,()->EmployeeFactory
                .BuildEmployee("","draybulambo4@gmail.com",name));
        String exceptionMessage= exception.getMessage();
        System.out.println(exceptionMessage);
    }
}
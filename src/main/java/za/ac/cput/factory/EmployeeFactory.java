package za.ac.cput.factory;

<<<<<<< HEAD
import za.ac.cput.domain.Employee;
import za.ac.cput.helper.Helper;
/*    Mutamba Prince Bulambo
      220177767
	  ADP3 - June Assessment 2022
	  School Management System
 */
public class EmployeeFactory {
    public static Employee BuildEmployee(String staffId, String Email, Name name)
    {
         Helper.checkStringPara("StaffID",staffId);
         Helper.IsValidEmail(Email);

        Name d = NameFactory.BuildName(name.getFirstName(),name.getMiddleName(),name.getLastName());
        return  new Employee.Builder().setStaff(staffId).setEmail(Helper.IsValidEmail(Email)).setName(d).builder();
    }

=======
public class EmployeeFactory {
>>>>>>> 09ce9bdb39db379dce1f41508ee6f166f8915a62
}

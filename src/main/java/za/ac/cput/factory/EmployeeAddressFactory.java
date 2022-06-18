package za.ac.cput.factory;
/*Martinez Safari 219325332
	  ADP3 - June Assessment 2022
	  School Management System
 */

import za.ac.cput.domain.Address;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.helper.Helper;


public class EmployeeAddressFactory {

    public static EmployeeAddress createEmployeeAddress(String staffID, String unitNumber, String complexNumber,
                                                        String streetNumber, String streetName, int postalCode, String cityID, String cityName,String countryId, String countryName){


        Helper.checkStringPara("staffID", staffID);
        Address address= AddressFactory.createAddress(unitNumber,complexNumber,streetNumber,streetName,postalCode,cityID,cityName,countryId,countryName);





        return new EmployeeAddress.Builder().setStaffId(staffID).setAddress(address).build();
    }

    public static EmployeeAddress.EmployeeAddressID buildID(EmployeeAddress employeeAddress) {
        return new EmployeeAddress.EmployeeAddressID(employeeAddress.getStaffID(), employeeAddress.getAddress());
    }

    public static void main(String[] args) {
        EmployeeAddress temp=EmployeeAddressFactory.createEmployeeAddress("2","123","123","Fame Cresent",
                "123",123,"123 ","DRC","566","DRC");
        System.out.println(temp.toString());

    }
}

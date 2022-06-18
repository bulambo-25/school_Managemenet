package za.ac.cput.factory;
/*
Farai Malone Chawora
Student Number 220145547
ADP 3 PRACTICAL Exam Assignment
Group 3
 */
import za.ac.cput.domain.Name;
import za.ac.cput.helper.Helper;

public class NameFactory {

    public static Name build(String firstName, String middleName, String lastName ){

        Helper.checkStringPara("FirstName",firstName);
        Helper.checkStringPara("LastName",lastName);
         if(middleName.equals(null)){

             middleName+="";
         }
         return new  Name.Builder().setFirstName(firstName).setMiddleName(middleName).setLastName(lastName).build();
    }

    public static void main(String[] args) {
        Name temp=NameFactory.build("Farai","","Chawora");
        System.out.println(temp.toString());
    }
}

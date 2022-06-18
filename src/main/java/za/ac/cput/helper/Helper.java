package za.ac.cput.helper;

import org.apache.commons.validator.routines.EmailValidator;

import org.apache.commons.lang3.StringUtils;
public class Helper {

    public static boolean isEmptyOrNull(String str)
    {
        return StringUtils.isEmpty(str);
    }
    public static String EmptyIfNull(String str)
    {
        if(isEmptyOrNull(str))
            return "";
        return str;
    }

    public static void checkStringPara(String paraName, String paraValue) {
        if (isEmptyOrNull(paraValue))
            throw new IllegalArgumentException("Invalid Value for " + paraName);

    }
    public static String IsValidEmail(String str) {
        if (EmailValidator.getInstance().isValid(str)) {
            return str;
        }
        System.out.println("Please enter correct email");
        String str2 = " Invalid Email";
        return str2;
    }
}

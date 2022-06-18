package za.ac.cput.helper;
/*
 * Name: Taariq Khan
 * Student number: 219231141
 * ADP372S – APPLICATIONS DEVELOPMENT PRACTICE 3
 * EXAMINER: K NAIDOO
 * MODERATOR: R BURGER
 * RELEASE DATE: 09th June 2022
 * DUE DATE: 18th June 2022
 * TOTAL MARKS: 100
 * */
import org.apache.commons.lang3.StringUtils;

public class helper
{
    public static boolean isEmptyOrNull(String str)
    {
        return StringUtils.isEmpty(str);
    }

    public static String setEmptyIfNull(String str)
    {
        if(isEmptyOrNull(str))
            return StringUtils.EMPTY;

        return str;
    }

    public static void checkStringParam(String paramName, String paramValue)
    {
        if(isEmptyOrNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for parameter: %s",paramName));
    }
}

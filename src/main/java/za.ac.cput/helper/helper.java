package za.ac.cput.helper;

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

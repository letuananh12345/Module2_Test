package TestModule2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
   public static final String PHONE_REGEX = "^[0]{1}[0-9]{3}.[0-9]{3}.[0-9]{3}$";
    public static final String EMAIL_REGEX =  "^[a-zA-Z]+[a-zA-Z0-9]*(@)[a-z]+.[a-z]{2,3}$";

    public static boolean valid(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}

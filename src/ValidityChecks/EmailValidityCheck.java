package ValidityChecks;

import ValidityChecks.ValidityCheck;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidityCheck  extends ValidityCheck  {

    @Override
    public <T>boolean check(T data) {
        if(data instanceof String){
            return checkEmail((String) data);
        }
        return false;
    }


    private boolean checkEmail(String email){
        // Regular expression found online to check for valid email addresses,
        // it does not take into consideration if it contains a valid existing domain.
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(email);
        if(m.find())
            return true;
        return false;

    }
    @Override
    public String toString() {
        return "Email Validity Check";
    }
}

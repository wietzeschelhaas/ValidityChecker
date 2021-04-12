package ValidityChecks;

public class AgeValidityCheck  extends ValidityCheck  {
    //Assuming that you cannot be older than 150
    int maxAge = 150;

    @Override
    public <T>boolean check(T data) {
        if(data instanceof String){
            String ageString = (String) data;
            if(containsAlfa(ageString))
                return false;

            int age = Integer.parseInt(ageString);
            return isValidAge(age);
        }
        else if(data instanceof Integer){
            return isValidAge((Integer) data);
        }else{
            System.out.println("Invalid datatype");
            return false;
        }
    }


    private boolean isValidAge(int age){
        if (age < 0)
            return false;
        if (age >maxAge)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Age Validity Check";
    }
}

package ValidityChecks;

public class NullValidityCheck extends ValidityCheck {
    @Override
    public <T>boolean check(T data) {
        if(data == null ){
            System.out.println("Failed null test");
            return false;
        }
        if(data instanceof String){
            if(data == "")
                return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Null Validity Check";
    }
}

import ValidityChecks.ValidityCheck;

import java.util.ArrayList;

public class ValidityChecker<T> {

    private ArrayList<ValidityCheck> checks;
    private T data;

    public ValidityChecker(T data,ValidityCheck... args){
        this.checks = new ArrayList<ValidityCheck>();
        this.data = data;

        for(ValidityCheck validityCheck: args){
            checks.add(validityCheck);
        }
    }
    //returns true if all checks succeed
    public boolean checkAll(){
        for (ValidityCheck validityCheck: checks){
           if (!validityCheck.check(data)){
               System.out.println((String) data + " Failed on " + validityCheck.toString());
               return false;
           }
        }
        return true;
    }
}

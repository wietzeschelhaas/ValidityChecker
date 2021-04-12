package ValidityChecks;

abstract public class ValidityCheck  {

    //To be implemented by ValidityCheck children
    abstract public <T>boolean check(T data);


    public boolean containsAlfa(String s){
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(!Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDigit(String s){
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

}

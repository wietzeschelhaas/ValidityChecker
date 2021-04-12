import ValidityChecks.*;

public class Main {
    public static void main(String[] args){
        //Example to check a valid social security number
        //to the ValidityChecker class we can give as many ValidityChecks as we want, as long as they inherit from the abstract ValidityCheck class
        ValidityChecker personNummerCheckTest = new ValidityChecker("197802022389",new NullValidityCheck(),new SocialSecurityValidityCheck());
        personNummerCheckTest.checkAll();

        //The supplied data is not a valid Email
        //The validity checker will report this.
        ValidityChecker personNummerCheckTest2 = new ValidityChecker("197802022389",new NullValidityCheck()
                ,new SocialSecurityValidityCheck()
                ,new EmailValidityCheck());
        personNummerCheckTest2.checkAll();

    }
}

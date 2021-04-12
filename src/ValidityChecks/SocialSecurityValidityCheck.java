package ValidityChecks;

import ValidityChecks.ValidityCheck;

public class SocialSecurityValidityCheck  extends ValidityCheck  {

    @Override
    public <T> boolean check(T data) {

        if(data instanceof String){
            String socialSecNum = (String) data;
            return isValidSocialSecNum(socialSecNum);
        }
        else if(data instanceof Long){
            String socialSecNum = data.toString();
            return isValidSocialSecNum(socialSecNum);
        }else{
            System.out.println("Invalid datatype");
            return false;
        }

    }


    private boolean isValidSocialSecNum(String socialSecNum){
        long socialSecurityNumber;

        //check to see if it doesnt con
        if(containsAlfa(socialSecNum))
            return false;

        //if length is not 10 or not 12, its cant be a valid social security number
        if (socialSecNum.length() != 10 && socialSecNum.length() != 12)
            return false;

        //remove the first 2 numbers if length is 12, they are not needed for calculation
        if (socialSecNum.length() == 12)
            socialSecurityNumber = Long.parseLong(socialSecNum.substring(2));
        else
            socialSecurityNumber = Long.parseLong(socialSecNum);

        //The last number is checksum
        long checkSum = socialSecurityNumber % 10;
        socialSecurityNumber /=10;

        long sum = 0;
        long tmp = 0;

        boolean alternate = true;
        while(socialSecurityNumber > 0) {
            tmp = socialSecurityNumber % 10;
            if(alternate){

                tmp *=2;
                //if tmp is bigger than 9 we need to calculate the sum of the two digits tmp is composed of
                if (tmp > 9){
                    tmp = (tmp % 10) + 1;
                }
            }
            sum += tmp;

            //flip bool
            alternate = !alternate;
            socialSecurityNumber /=10;

        }

        return (10 - (sum % 10)) % 10 == checkSum;
    }

    @Override
    public String toString() {
        return "Social security number Validity Check";
    }

}

package tests;

import ValidityChecks.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidityCheckTest {

    @Test
    void containsAlfa() {
        ValidityCheck nvc = new NullValidityCheck();
        assertEquals(false,nvc.containsAlfa("199605091111"));
        assertEquals(true,nvc.containsAlfa("19960509-1111"));
    }

    @Test
    void containsDigit() {
        ValidityCheck nvc = new NullValidityCheck();
        assertEquals(true,nvc.containsDigit("1234567a7889"));
        assertEquals(true,nvc.containsDigit("199605091111"));
        assertEquals(false,nvc.containsDigit("abcdefrgjhw"));

    }

    @Test
    void socialSecValidTest(){
        ValidityCheck socialSecTest = new SocialSecurityValidityCheck();
        assertEquals(true,socialSecTest.check("197802022389"));
        assertEquals(true,socialSecTest.check("7802022389"));

        assertEquals(true,socialSecTest.check("198204112380"));

        assertEquals(false,socialSecTest.check("198204112389"));


        assertEquals(false,socialSecTest.check("19820411a380"));

        assertEquals(false,socialSecTest.check("1111"));
    }
    @Test
    void ageValidTest(){
        ValidityCheck ageValidityCheck = new AgeValidityCheck();
        assertEquals(false,ageValidityCheck.check("151"));
        assertEquals(false,ageValidityCheck.check("20a"));
        assertEquals(false,ageValidityCheck.check(151));
        assertEquals(false,ageValidityCheck.check(-4));


        assertEquals(true,ageValidityCheck.check(149));

    }
    @Test
    void emialValidTest(){
        ValidityCheck ageValidityCheck = new EmailValidityCheck();
        assertEquals(true,ageValidityCheck.check("user@domain.com"));
        assertEquals(true,ageValidityCheck.check("user@gmail.com"));

        assertEquals(false,ageValidityCheck.check(".user@gmail.com"));
        assertEquals(false,ageValidityCheck.check("user@gmail.com."));
        assertEquals(false,ageValidityCheck.check("user@gmail..com"));

    }
}
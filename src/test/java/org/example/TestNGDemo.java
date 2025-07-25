package org.example;

import org.testng.annotations.*;


public class TestNGDemo {
    /***
     * @Test params
     * description -> for test description
     * priority -> to decide which test to tun first
     * skip test -> (use enabled) = false

     * BeforeClass -> Runs at the start of class
     * AfterClass -> Runs at the end of the class
     * BeforeMethod -> Runs after every method
     * AfterMethod -> Runs after every method
     * Assert      -> In testNG we needn't use if and else condition instead we can use assert
     */

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeTest(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @Test(description = "Validating a and b are same")
    public void sum(){
        int a = 4;
        int b = 5;
        assert a == b;
    }

    @Test(description = "Check substring")
    public void verifySubstring(){
        assert "Ayushi".contains("vattu");
    }

    // How to skip the test
    @Test(description = "Skipping this test", enabled = false)
    public void skip(){
        assert true;
    }

    // Setting priority
    @Test(description = "Setting the priority", priority = 1)
    public void settingPriority(){
        assert true;
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

}

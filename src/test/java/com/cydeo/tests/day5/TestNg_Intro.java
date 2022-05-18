package com.cydeo.tests.day5;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNg_Intro {

    @BeforeClass
    public void setupMethod(){
        System.out.println("Before class is running");
    }
    @AfterClass
    public void teaeDownClass(){
        System.out.println("After class is running");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("before method is running...");
    }
    @AfterMethod
    public void tearDownMethods(){
        System.out.println(".........after method is running");
    }

    @Test
    public void test1(){

        System.out.println("Test 1 is running");

        String actual="Apple";
        String expected="apple";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test2(){
        System.out.println("Test 2 is running");

        String actual="apple";
        String expected="apple";

        Assert.assertTrue(actual.equals(expected));
    }
}

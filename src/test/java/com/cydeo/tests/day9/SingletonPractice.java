package com.cydeo.tests.day9;

import org.testng.annotations.Test;

public class SingletonPractice {
    @Test(priority = 2)
    public void singleton_practice(){
        String str=Singleton.word();
        System.out.println("str = " + str);

        String str2=Singleton.word();
        System.out.println("str2 = " + str2);

        String str3=Singleton.word();
        System.out.println("str3 = " + str3);



    }
    @Test(priority = 1)
    public void singleton_practice2() {
        String str4= Singleton.word();
        System.out.println("str4 = " + str4);
    }
}

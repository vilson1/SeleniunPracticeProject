package com.cydeo.tests.day9;

import org.testng.annotations.Test;

public class SingletonPractice {
    @Test
    public void singleton_practice(){
        String str=Singleton.word();
        System.out.println("str = " + str);

        String str2=Singleton.word();
        System.out.println("str = " + str2);

        String str3=Singleton.word();
        System.out.println("str = " + str3);

    }
}

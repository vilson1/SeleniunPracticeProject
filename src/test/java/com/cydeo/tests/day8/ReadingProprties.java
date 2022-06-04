package com.cydeo.tests.day8;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProprties {
    @Test
    public void readingPropertiesTest() throws IOException {
        // Create the object of Properties
        Properties properties=new Properties();

        //Open th file using FileInputStream

        FileInputStream file=new FileInputStream("configuration.properties");

        // Load the properties object by using FileInputStream.
        properties.load(file);

        //Use properties object to read the value
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
    }
}

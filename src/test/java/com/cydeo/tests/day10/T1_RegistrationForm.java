package com.cydeo.tests.day10;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class T1_RegistrationForm {
    @Test
    public void registrationForm(){
//        1. Open browser
//        2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));
        Faker faker=new Faker();
//        3. Enter first name
        WebElement firstName=Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));

        firstName.sendKeys(faker.name().firstName());
//        4. Enter last name
        WebElement lastName=Driver.getDriver().findElement(By.xpath("//input[@placeholder='last name']"));
        lastName.sendKeys(faker.name().lastName());
//        5. Enter username
        WebElement username=Driver.getDriver().findElement(By.xpath("//input[@data-bv-field='username']"));
        String userName=faker.name().username().replace(".","");
        username.sendKeys(userName);
//        6. Enter email address
        WebElement email=Driver.getDriver().findElement(By.xpath("//input[@data-bv-field='email']"));
        email.sendKeys(userName+"@gmail.com");
//        7. Enter password
        WebElement password=Driver.getDriver().findElement(By.xpath("//input[@data-bv-field='password']"));
        password.sendKeys(faker.bothify("#?#?#?#?#?#?#?"));
//        8. Enter phone number
        WebElement phone=Driver.getDriver().findElement(By.xpath("//input[@data-bv-field='phone']"));
        phone.sendKeys(faker.numerify("###-#####-####"));
//        9. Select a gender from radio buttons
        WebElement gender=Driver.getDriver().findElement(By.xpath("//input[@value='female']"));

//        10. Enter date of birth
        WebElement dateOfBirth=Driver.getDriver().findElement(By.xpath("//input[@data-bv-field='birthday']"));
        dateOfBirth.sendKeys("18/12/1991");
//        11. Select Department/Office
        Select department=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        department.selectByIndex(faker.number().numberBetween(0,9));
//        12. Select Job Title
        Select jobTitle=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByIndex(faker.number().numberBetween(0,8));

//        13. Select programming language from checkboxes
        WebElement languange=Driver.getDriver().findElement(By.xpath("//label[.='Java']"));
        languange.click();
//        14. Click to sign up button
        WebElement button=Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));

//        15. Verify success message “You’ve successfully completed registration.” is
//        displayed.
    }
}

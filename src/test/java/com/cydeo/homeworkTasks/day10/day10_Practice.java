package com.cydeo.homeworkTasks.day10;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class day10_Practice {
    @Test
    public void T1_test1(){
//    TC#1: Registration form confirmation
//    Note: Use JavaFaker OR read from configuration.properties file when possible.
//            1. Open browser
//2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));
        Faker faker=new Faker();
//3. Enter first name
        WebElement firstName=Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        String fName=faker.name().firstName();
        firstName.sendKeys(fName);

//4. Enter last name
        WebElement lastName=Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());
//5. Enter username
        WebElement username=Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        username.sendKeys(faker.bothify(fName+"####"));
//6. Enter email address
        WebElement email=Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(faker.bothify(fName+"##@gmail.com"));

//7. Enter password
        WebElement password=Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.bothify("####????"));
//8. Enter phone number
        WebElement phone=Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys(faker.phoneNumber().phoneNumber());
//9. Select a gender from radio buttons
        WebElement gender=Driver.getDriver().findElement(By.xpath("(//input[@name='gender'])[1]"));
        gender.click();
//10. Enter date of birth
        WebElement birthday=Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        birthday.sendKeys(faker.numerify(faker.number().numberBetween(1,12)+"/"+faker.number().numberBetween(1,28)+"/"+faker.number().numberBetween(1970,2022)));
//11. Select Department/Office
//12. Select Job Title
//13. Select programming language from checkboxes
//14. Click to sign up button
//15. Verify success message “You’ve successfully completed registration.” is
//    displayed.
//
//
//            Note:
//            1. Use new Driver utility class and method
//2. User JavaFaker when possible
//3. User ConfigurationReader when it makes sense

    }

    @Test
     public void T2_upload(){
//        1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");
//        2. Find some small file from your computer, and get the path of it.
        WebElement upload=Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
//        3. Upload the file.
        upload.sendKeys("C:\\Users\\User\\Desktop\\photo.jpg");
        WebElement uploadButton=Driver.getDriver().findElement(By.xpath("//input[@class='button']"));
        uploadButton.click();
//        4. Assert:
        WebElement message=Driver.getDriver().findElement(By.xpath("//h3"));
        Assert.assertTrue(message.isDisplayed());
//        -File uploaded text is displayed on the page
    }

    @Test
    public void T3_hoverTest(){
//        1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");
        Actions actions=new Actions(Driver.getDriver());

//        2. Hover over to first image
        WebElement user1=Driver.getDriver().findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
        WebElement username1=Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement viewProfile1=Driver.getDriver().findElement(By.xpath("(//a[.='View profile'])[1]"));
        actions.moveToElement(user1).perform();
        Assert.assertTrue(username1.isDisplayed());
        Assert.assertTrue(viewProfile1.isDisplayed());
//        3. Assert:
//        a. “name: user1” is displayed
//        b. “view profile” is displayed
//        4. Hover over to second image
        WebElement user2=Driver.getDriver().findElement(By.xpath("(//img[@alt='User Avatar'])[2]"));
        WebElement username2=Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement viewProfile2=Driver.getDriver().findElement(By.xpath("(//a[.='View profile'])[2]"));

        actions.moveToElement(user2).perform();
        Assert.assertTrue(username2.isDisplayed());
        Assert.assertTrue(viewProfile2.isDisplayed());
//        5. Assert:
//        a. “name: user2” is displayed
//        b. “view profile” is displayed
//        6. Hover over to third image
        WebElement user3=Driver.getDriver().findElement(By.xpath("(//img[@alt='User Avatar'])[3]"));
        WebElement username3=Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));
        WebElement viewProfile3=Driver.getDriver().findElement(By.xpath("(//a[.='View profile'])[3]"));

        actions.moveToElement(user3).perform();
        Assert.assertTrue(username3.isDisplayed());
        Assert.assertTrue(viewProfile3.isDisplayed());
//        7. Confirm:
//        a. “name: user3” is displayed
//        b. “view profile” is displayed
    }

    @Test
    public void T4_T5_ScrollPractice()  {
//        1- Open a chrome browser
//        2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");
        Actions actions=new Actions(Driver.getDriver());

//        3- Scroll down to “Powered by CYDEO”
        BrowserUtils.sleep(2);
        WebElement cydeo=Driver.getDriver().findElement(By.xpath("//div[text()='Powered by ']"));


        actions.moveToElement(cydeo).perform();
//        4- Scroll using Actions class “moveTo(element)” method

//        1- Continue from where the Task 4 is left in the same test.
        WebElement home=Driver.getDriver().findElement(By.xpath("//a[text()='Home']"));
//        2- Scroll back up to “Home” link using PageUP button
        BrowserUtils.sleep(2);
        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    @Test
    public void T6_jsPractice(){
//        1- Open a chrome browser
//        2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");
//        3- Use below JavaScript method and scroll
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();

//        a.  750 pixels down 10 times.
        for (int i = 0; i < 10; i++) {

            BrowserUtils.sleep(2);
            js.executeScript("window.scrollBy(0,720)");
        }
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(2);
            js.executeScript("window.scrollBy(0,-720)");
        }
//                b.  750 pixels up 10 times
//
//        JavaScript method to use : window.scrollBy(0,0)
    }

    @Test
    public void T7_jsPractice2(){
//        1- Open a chrome browser
//        2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
//        3- Scroll down to “Cydeo” link
        WebElement cydeo=Driver.getDriver().findElement(By.xpath("//div[text()='Powered by ']"));
        WebElement homeLink=Driver.getDriver().findElement(By.xpath("//a[text()='Home']"));
        BrowserUtils.sleep(2);
        js.executeScript("arguments[0].scrollIntoView(true);", cydeo,homeLink);


        BrowserUtils.sleep(2);
        js.executeScript("arguments[1].scrollIntoView(true)",cydeo,homeLink);
//        4- Scroll up to “Home” link
//        5- Use below provided JS method only
//
//        JavaScript method to use : arguments[0].scrollIntoView(true)
//
//        Note: You need to locate the links as web elements and pass them as
//        arguments into executeScript() method
    }
}

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;


public class BasePage {

    protected static WebDriver driver;

    public static void main(String[] args) {


        //set property method for opening chrome driver from the source as mentioned after comma
        System.setProperty("webdriver.chrome.driver","src/test/java/Drivers/chromedriver.exe");

        //creating an object of the Chromedriver
        driver = new ChromeDriver();

        //this is to use unique email address everytime we run the program so website won't give error message of id already exist
        //this is time stamp which generate current date and time as per the format
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());

        //manage method to  maximize window of the browser
        driver.manage().window().maximize();

        //get method to navigate to given URL
        driver.get("https://demo.nopcommerce.com/");

        //finding element by class name for registration link element and clicking on it
        driver.findElement(By.className("ico-register")).click();

        //finding Firstname, Lastname, Email, Password, conf password textboxes elements with its id and entering text by sendKeys method
        //finding register button with id and click method to click on it
        driver.findElement(By.id("FirstName")).sendKeys("Rajesh");
        driver.findElement(By.id("LastName")).sendKeys("Patel");
        driver.findElement(By.id("Email")).sendKeys("Rajesh.Patel"+timeStamp+"@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Rajesh123456");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Rajesh123456");
        driver.findElement(By.id("register-button")).click();


        //after clicking register button, the message appears on the screen confirming registration
        //finding that message element by class name and storing it text to the String variable msg using getText method
        String msg = driver.findElement(By.className("result")).getText();

        //printing the stored message in the variable msg
        System.out.println(msg);



        //this is to close the browser // .close() can be used to close the tab
        driver.quit();










    }

}

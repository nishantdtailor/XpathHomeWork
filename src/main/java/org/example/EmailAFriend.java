package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;

public class EmailAFriend {

    protected static WebDriver driver;

    public static void main(String[] args) {

        //set property method for opening chrome driver from the source as mentioned after comma
        System.setProperty("webdriver.chrome.driver","src/test/java/Drivers/chromedriver.exe");


        //creating an object of the Chromedriver
        driver = new ChromeDriver();

        //this is to use unique email address for send to a friend email
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());

        //get method to navigate to given URL
        driver.get("https://demo.nopcommerce.com/");


        //finding following 2 elements using xpath as couldnt find any unique id or class,  name etc
        driver.findElement(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div[2]/div/div/a[1]")).click();
        driver.findElement(By.xpath("//div[@class=\"overview-buttons\"]/div[3]/button[@class=\"button-2 email-a-friend-button\"]")).click();


        //managed to find all 3 textbox elements by its id and sending email address text using sendkeys
        driver.findElement(By.id("FriendEmail")).sendKeys("rocket"+timeStamp+"@pocket.com"); // used timestamp for unique email address
        driver.findElement(By.id("YourEmailAddress")).sendKeys("pocket"+timeStamp+"@rocket.com"); // same as above
        driver.findElement(By.id("PersonalMessage")).sendKeys("This is a fantastic laptop, I would recommend it");

        //finding send email button element by its name and clicking on it
        driver.findElement(By.name("send-email")).click();

        //after clicking on send email, the message on the screen was captured in to the variable message
        //xpath was used to find the element of that text message on the screen
        String message = driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]/ul/li[1]")).getText();

        //to print the  stored message in the variable
        System.out.println(message);

        //to close the browser
        driver.quit();

    }
}

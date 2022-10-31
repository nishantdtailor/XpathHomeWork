package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewsComments {

    protected static WebDriver driver;

    public static void main(String[] args) {


        //set property method for opening chrome driver from the source as mentioned after comma
        System.setProperty("webdriver.chrome.driver","src/test/java/Drivers/chromedriver.exe");

        //creating an object of the Chromedriver
        driver = new ChromeDriver();

        //get method to navigate to given URL
        driver.get("https://demo.nopcommerce.com/");

        //clicking on new release details button using partiallink text method to find the element
        driver.findElement(By.partialLinkText("release")).click();


        //finding textbox elements by its id for title and comment and using send key to type in the textbox
        driver.findElement(By.id("AddNewComment_CommentTitle")).sendKeys("Joe Bloggs");
        driver.findElement(By.id("AddNewComment_CommentText")).sendKeys("This is a demo website for test engineers");

        //element by name and clicking on new comment button
        driver.findElement(By.name("add-comment")).click();

        //capturing message on the screen, storing it in the variable commentmessage using getText method
        //had to use xpath and couldn't manage to find any unique options for message

        String commentmessage = driver.findElement(By.xpath("//div[@class=\"fieldset new-comment\"]/div[2]/div[@class=\"result\"]")).getText();

        //printing the message stored in the variable commentmessage
        System.out.println(commentmessage);

        //closing web browser
        driver.quit();

    }


}

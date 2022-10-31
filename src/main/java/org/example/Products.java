package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Products {

    protected static WebDriver driver;

    public static void main(String[] args) {


        //set property method for opening chrome driver from the source as mentioned after comma
        System.setProperty("webdriver.chrome.driver","src/test/java/Drivers/chromedriver.exe");

        //creating an object of the Chromedriver
        driver = new ChromeDriver();


        //get method to navigate to given URL
        driver.get("https://demo.nopcommerce.com/");

        ////manage method to  maximize window of the browser
        driver.manage().window().maximize();

        //finding computers and desktops element by Linktext
        driver.findElement(By.linkText("Computers")).click();
        driver.findElement(By.linkText("Desktops")).click();

        //created 3 string variables and used partiallinktext to find the elements
        //stored all 3 products name into individual String variables and priting them
        String title1 = driver.findElement(By.partialLinkText("Build")).getText();
        System.out.println(title1);
        String title2 = driver.findElement(By.partialLinkText("Digital")).getText();
        System.out.println(title2);
        String title3 = driver.findElement(By.partialLinkText("Lenovo")).getText();
        System.out.println(title3);


        //to close the browser
        driver.quit();



    }

}

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageCategories {

    protected static WebDriver driver;

    public static void main(String[] args) {
        //set property method for opening chrome driver from the source as mentioned after comma
        System.setProperty("webdriver.chrome.driver","src/test/java/Drivers/chromedriver.exe");

        //creating an object of the Chromedriver
        driver = new ChromeDriver();

        //get method to navigate to given URL
        driver.get("https://demo.nopcommerce.com/");


        //created separate String variable to store categories names
        //used lintext method to find the elements except DigitalDownload where I used partial linktext where the text was too long
        //stored them in relevant variable using getText method
        String catComputers = driver.findElement(By.linkText("Computers")).getText();
        String catElectronics = driver.findElement(By.linkText("Electronics")).getText();
        String catApparel = driver.findElement(By.linkText("Apparel")).getText();
        String catDigitalDownload = driver.findElement(By.partialLinkText("Digital")).getText();
        String catBooks = driver.findElement(By.linkText("Books")).getText();
        String catJewelry = driver.findElement(By.linkText("Jewelry")).getText();
        String catGiftCards = driver.findElement(By.linkText("Gift Cards")).getText();

        //printed categoties names using concate in single line
        System.out.println(catComputers+" "+catElectronics+" "+catApparel+" "+catDigitalDownload+" "+catBooks+" "+catJewelry+" "+catGiftCards);

        //to close browser
        driver.quit();


    }

}

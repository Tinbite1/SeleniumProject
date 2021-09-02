package com.cybertek.day02_locators_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTextPartialLinkTextPractice {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");

        // click on first link  "A/B Testing"
//        WebElement firstLnk = driver.findElement(By.linkText("A/B Testing")) ;
//        firstLnk.click();

        driver.findElement(By.linkText("A/B Testing")).click();

        // navigate back to home page
        driver.navigate().back();

        // maximize the screen here
        driver.manage().window().maximize();

        // click on second link , either full linkText or PartialLinkText
        // driver.findElement(By.linkText("Add/Remove Elements")).click();
        // Partial link text will return first match if you have multiple elements
        WebElement addOrRemoveLink = driver.findElement(By.partialLinkText("Add/Remove"));
        addOrRemoveLink.click();
        // click on "Home" link to go back to home
        driver.findElement(By.linkText("Home")).click();

        // click on "Redirect Link"
        driver.findElement(By.linkText("Redirect Link")).click();

        // close browser
        driver.close();

    }

}

package com.cybertek.day02_locators_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByPartialText_GetText_Method {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");

        // identify the link with text "Disappearing Elements"
        // using partial link text then get the full text out using new method getText
        WebElement myLnk = driver.findElement(By.partialLinkText("Disappearing")) ;

        //System.out.println("myLnk.getText() = " + myLnk.getText() );

        String fullLinkText = myLnk.getText() ;
        System.out.println("fullLinkText = " + fullLinkText);

        // what if I just provide partial link as letter A
        // it will just return very first that match the criteria
        WebElement aLink = driver.findElement(By.partialLinkText("A")) ;
        System.out.println("aLink.getText() = " + aLink.getText());


        driver.quit();


    }

}

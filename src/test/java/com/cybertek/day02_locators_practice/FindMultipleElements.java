package com.cybertek.day02_locators_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindMultipleElements {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");

        // get all the links that have partial text A in it
        List<WebElement> allLinks = driver.findElements(By.partialLinkText("A"));
        // get the size of this list so we know how many link with partial text A
        System.out.println("allLink.size() = " + allLinks.size());

        // get the first item and get the text
        WebElement firstItem = allLinks.get(0);
        System.out.println("firstItem.getText() = " + firstItem.getText());

        WebElement secondItem = allLinks.get(1) ;
        System.out.println("secondItem.getText() = " + secondItem.getText());

        // iterate over whole list and print out the text
        for( WebElement eachElement :allLinks ){

            System.out.println("eachElement.getText() = " + eachElement.getText());

        }


        // findElement method will throw exception when it can not find element
        // findElements method will return empty List<WebElement>

        // close the browser
        driver.quit();

    }

}

package com.cybertek.day03_locate_by_tag_class_getatt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementByTagName {

    public static void main(String[] args) {

        /*
        * Purple tag name
        * Orange attribute name
        * blue attribute value
        * black it is the text
        * */

        // open chrome and navigate to practice site
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        // identify first element with tag name <a>

        WebElement firstLnk = driver.findElement(By.tagName("a")) ;
        // now lets get the text to find out
        System.out.println("firstLnk.getText() = " + firstLnk.getText());

        // what if I wanted to find and store all elements with <a> tag -->> findElements
        List<WebElement> allATagElements = driver.findElements(By.tagName("a"));
//        allATagElements.size().soutv and hit enter
        System.out.println("allATagElements.size() = " + allATagElements.size());

        // iterate over this list , get the text of the link and get attribute and print them out
        // allATagElements.iter and hit enter , give a name to each element
        for (WebElement eachElement : allATagElements) {
            System.out.println("eachElement.getText() = " + eachElement.getText());
            System.out.println("eachElement.getAttribute(\"href\") = " + eachElement.getAttribute("href"));
        }

        // get first element with <h1> tag and get the text out of it
        WebElement firstH1TagElm = driver.findElement(By.tagName("h1")) ;
        System.out.println("firstH1TagElm.getText() = " + firstH1TagElm.getText());

        // you can also use span for this task because child element that hold same text


        driver.quit();


    }

}

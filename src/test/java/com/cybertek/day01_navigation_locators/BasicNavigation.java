package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) {

        // set up chrome driver
        WebDriverManager.chromedriver().setup();
        // create ChromeDriver Object
        WebDriver driver = new ChromeDriver();
        // navigate to https://yahoo.com
        driver.get("https://yahoo.com");
         /* navigate using
            - get("url")
            - navigate().to("url")
            - navigate().back()
            - navigate().forward()
            - navigate().refresh()

        *
        * */
        // navigate().to("url")
        driver.navigate().to("https://google.com/");


    }

}

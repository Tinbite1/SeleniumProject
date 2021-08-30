package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicNavigation_FireFox {

    public static void main(String[] args) {

        // 1. set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // 2. Create Webdriver instance using FirefoxDriver object
        WebDriver driver = new FirefoxDriver();
        // 3. navigate to "https://cybertekschool.com"


    }

}

package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManagingBrowserWindow {

    public static void main(String[] args) {

        // set up chrome driver
        WebDriverManager.chromedriver().setup();
        // create ChromeDriver Object
        WebDriver driver = new ChromeDriver() ;
        // navigate to https://google.com
        driver.get(" https://google.com ");

        // Maximize the browser window
        driver.manage().window().maximize();

        // make the browser window full screen
        driver.manage().window().fullscreen();


        // quit the browser
        driver.quit();

    }

}

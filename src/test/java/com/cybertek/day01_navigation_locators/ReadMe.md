# Day 1 Note

## Selenium Starter
```java
// set up chrome driver
WebDriverManager.chromedriver().setup();
// create ChromeDriver Object
WebDriver driver = new ChromeDriver();
// navigate to https://amazon.com
driver.get("https://amazon.com");
```
You can automate [Firefox browser](https://www.mozilla.org/en-US/firefox/new/) just by setting up firefox driver same way we did to chrome and Creating FirefoxDriver.
The rest of the code will remain the same as we did [here](BasicNavigation_FireFox.java)


## Basic navigation methods
We can use any navigation methods we would usually do in browser.
![navigation](https://user-images.githubusercontent.com/59104509/131442482-dc11ccd4-c713-45dd-aca5-1510312d0ca9.png)

- `driver.get("Your Full URL")`
- `driver.navigate().to("Your Full URL")`
- `driver.navigate().back()`
- `driver.navigate().forward()`
- `driver.navigate().refresh()`

You can also navigate to local html file as we did [here](BasicNavigation_LocalHTML_FIle.java) .

## Closing the browser
You can close browser tab or window opened by webdriver using `close` and `quit` method.
- `driver.close()` will close current tab in focus
- `driver.quit()` will close browser window along with all the tabs in it

## Basic browser window management
You can adjust the screen size or location any way that you want using driver manage option.
- Making the browser window full screen
  - `driver.manage().window().fullscreen();`
- Making the browser window maximized
  -  driver.manage().window().maximize();

## Locating Elements on the page
In order to be able to interact with the element we will need to locate the element first.

There are 2 methods in WebDriver for this to return `WebElement` object.
- `findElement(By.locatorType("locatorValue"))` return single `WebElement`
- `findElements(By.locatorType("locatorValue"))` return all matching elements as `List<WebElement>`

There are 8 common locators in Selenium and each of them have their own feature
- By ID
  - Id attribute of the element (unique per page and most stable)
  - `WebElement searchBox = driver.findElement(By.id("ybar-sbq") ) ;`
- By Name
  - name attribute of html element (seen mostly in form elements)
  - `WebElement searchBox = driver.findElement(By.name("q") ) ;`
- By LinkText
  - specifically for `<a>` tag using link text
  - `WebElement aboutLnk = driver.findElement(By.LinkText("About") ) ;`
- By LinkText
  - specifically for `<a>` tag using partial link text
  - `WebElement aboutLnk = driver.findElement(By.PartialLinkText("part of link text here") ) ;`
- By Tag Name
  - useful when you want to get all elements with certain tag (not ideal, less used)
  - `WebElement elm = driver.findElement(By.tagName("input") ) ;`
- By Class Name
  - using class attribute of the element
  - `WebElement elm = driver.findElement(By.className("group") ) ;`
- By CSS selector
  - using the css which was used to style the element in the first place
  - `WebElement elm = driver.findElement(By.cssSelector("#firstName") ) ;`
- By XPath
  - advanced technic to identify the element using html hierarchy and additional attributes
  - `WebElement elm = driver.findElement(By.xPath("//table/tbody/tr[2]/td[2]") ) ;`


We learned [Find Element By Id](FindElementById.java) , [Find Element By Name](FindElementByName.java) and [Find Element By Link Text](FindElementByLinkText.java)

One the elements are identified , it can be interacted like entering text into the text box , click on the link and buttons(submit if it's form button)

Few example we did today as below
```java
  WebElement searchBox = driver.findElement(By.name("p")) ;
  searchBox.sendKeys("Selenium"); // enter Selenium 

  WebElement searchBtn = driver.findElement(By.name("btnK")) ;
  searchBtn.submit(); // click to submit the search form search button
        
  WebElement aboutLink = driver.findElement(By.linkText("About") ) ;
  aboutLink.click();  // click on the link
```


We will continue to learn more about other locators in coming classes.

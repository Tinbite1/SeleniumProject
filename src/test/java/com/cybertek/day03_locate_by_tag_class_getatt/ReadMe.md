# Day 3 Note 

## Quick Recap on [Homework](../day02_locators_practice/ReadMe.md#homework-1)
- `By.linkText("something")` will look for exact match 
- If there is any extra text or white space including line break generated by `<br>` it will not work.
- `By.partialLinkText("part")` will use case-sensitive contains logic.
- `getText()` method will get the text of current element and all it's chile element.
  - Given below div element with 2 child
  - ```html
      <div id="content">
         <p>Paragraph 1</p>
         <p>Paragraph 2</p>
      </div>    
      ```
  - `driver.findElement(By.id("content")).getText()` will return both paragraphs text

## Getting element attribute value 

An HTML Element is consist of html tag and it's attribute and optionally text in between closing tag and opening tag

Below is the Google search box and button elements with some attributes and value

```html
<input class="gLFyf gsfi"  maxlength="2048" name="q" type="text" aria-autocomplete="both" aria-haspopup="false"  autocomplete="off"   role="combobox" spellcheck="false" title="Search" value="Selenium" aria-label="Search">
```
<input class="gLFyf gsfi"  maxlength="2048" name="q" type="text" aria-autocomplete="both" aria-haspopup="false"  autocomplete="off"   role="combobox" spellcheck="false" title="Search" value="Selenium" aria-label="Search">
<input class="gNO89b" value="Google Search" aria-label="Google Search" name="btnK" type="submit" >

- element : search box 
- tag name :  `input`
- attributes : 
  - name : `class`  value : `gLFyf gsfi`
  - name : `maxlength`  value : `2048`
  - name : `name`  value : `q`
  - name : `type`  value : `text`
  - name : `role`  value : `combobox`
  - name : `value`  value : `Selenium`

```html
<input class="gNO89b" value="Google Search" aria-label="Google Search" name="btnK" type="submit" >
```
- element : Google Search Input Button
- tag name :  `input`
- attributes :
  - name : `class`  value : `gNO89b`
  - name : `aria-label`  value : `Google Search`
  - name : `name`  value : `btnK`
  - name : `type`  value : `submit`
  - name : `value`  value : `Google Search`

Here is the Sign in link on top right corner

<a class="gb_3 gb_4 gb_9d gb_3c" href="https://accounts.google.com/ServiceLogin" target="_top">Sign in</a>

```html
<a class="gb_3 gb_4 gb_9d gb_3c" href="https://accounts.google.com/ServiceLogin" target="_top">Sign in</a>
```
- element : Sign in Link
- tag name :  `a`
- attributes :
  - name : `class`  **values** : `gb_3` `gb_4` `gb_9d` `gb_3c` (everytime there is a space it means it's a different class, one element can have many classes to assign different styles)
  - name : `href`  value : `https://accounts.google.com/ServiceLogin`
- text : `Sign in`

In a NutShell easy way to train your eye to look at correct information in html dom :
> - Purple -> tag name :purple_heart:
> - Orange -> attribute name :orange_heart:
> - blue -> attribute value :blue_heart:
> - black -> it is the text :black_heart:

--- 
[Here](GetElementAttribute.java) in this class We tried to get attributes of elements and printed them out. 
```java
 WebElement searchBox = driver.findElement(By.name("q")) ;
  searchBox.sendKeys("Selenium");
  
  // get the class attribute
  System.out.println("searchBox.getAttribute(\"class\") = "
                          + searchBox.getAttribute("class"));
  //maxlength
  System.out.println("searchBox.getAttribute(\"maxlength\") = "
          + searchBox.getAttribute("maxlength"));
  //title
  System.out.println("searchBox.getAttribute(\"title\") = "
          + searchBox.getAttribute("title"));
  
  //autocapitalize
  System.out.println("searchBox.getAttribute(\"autocapitalize\") = "
          + searchBox.getAttribute("autocapitalize"));
  //spellcheck
  System.out.println("searchBox.getAttribute(\"spellcheck\") = "
          + searchBox.getAttribute("spellcheck"));
  //role
  System.out.println("searchBox.getAttribute(\"role\") = "
          + searchBox.getAttribute("role"));
  
  
  // using value attribute of input text box to extract the text inside
  System.out.println("searchBox.getAttribute(\"value\") = "
          + searchBox.getAttribute("value"));
```

## Locating Element(s) Using Tag Name

You can locate element using tag name use `By.tagName("tag name goes here")`

Tag name is usually not unique since it's not enough information just by providing tag name and yet it can be useful in some pages where there is only one type of element with that tag or if you want to get all the elements with same tag. 

For example as we did [here](FindElementByTagName.java) :
```java
// in cybertek practice site
driver.get("http://practice.cybertekschool.com/");
        // identify first element with tag name <a>
WebElement firstLnk = driver.findElement(By.tagName("a")) ;
// now lets get the text to find out
System.out.println("firstLnk.getText() = " + firstLnk.getText());  // Home

// get first element with <h1> tag and get the text out of it
WebElement firstH1TagElm = driver.findElement(By.tagName("h1")) ;
System.out.println("firstH1TagElm.getText() = " + firstH1TagElm.getText());


```
If you use `findElement` it will always return first match from html dom. 

If we want to get all the links with `<a>` tag, it will look as below
```java
List<WebElement> allATagElements = driver.findElements(By.tagName("a"));
//        allATagElements.size().soutv and hit enter
System.out.println("allATagElements.size() = " + allATagElements.size());

// iterate over this list , get the text of the link and get attribute and print them out
// allATagElements.iter and hit enter , give a name to each element
for (WebElement eachElement : allATagElements) {
    System.out.println("eachElement.getText() = " + eachElement.getText());
    System.out.println("eachElement.getAttribute(\"href\") = " + eachElement.getAttribute("href"));
}
```

## Find Element(s) using Class Name 

Class attribute in an element is usually used to apply styling to the one element or multiple elements together. 

On [practice site ](http://practice.cybertekschool.com/)

Assuming this is the element
```html
<span class="h1y">Test Automation Practice</span>
```
identify this element using its class attribute will look like this

```java
WebElement elm1 = driver.findElement(By.className("h1y"));
System.out.println("elm1.getText() = " + elm1.getText());
```

You can also identify many elements with same styles AKA same class name using `findElements` and `By.className("class value")`

Given these are the elements 
```html
<ul class="list-group">
  <li class="list-group-item"><a href="/abtest">A/B Testing</a></li>
  <li class="list-group-item"><a href="/add_remove_elements/">Add/Remove Elements</a></li>
  <li class="list-group-item"><a href="/autocomplete">Autocomplete</a></li>
  <li class="list-group-item"><a href="/basic_auth">Basic Auth</a> (user and pass: admin)</li>
  <li class="list-group-item"><a href="/broken_images">Broken Images</a></li>
  <!--......-->
</ul>
```

We can identify all `<li>` elements with same class name and print out the text.
```java
List<WebElement> allLiTagElements = driver.findElements(By.className("list-group-item"));
// get the size of all the elements
System.out.println("allLiTagElements.size() = " + allLiTagElements.size());

// iterate over all the elements and get the text of each element
for (WebElement eachLiElement : allLiTagElements) {
    System.out.println("eachLiElement.getText() = " + eachLiElement.getText());
}

```

## Homework 
Use the technic we learned by applying in different websites. 

Here is one more practice site.

You can do it by following short video **018** [instruction on canvas ](https://learn.cybertekschool.com/courses/575/pages/018-dot-findingelement-practicechallenge?module_item_id=42201)

You may check out the solutions in [part1](https://learn.cybertekschool.com/courses/575/pages/018-dot-solution-part1?module_item_id=42202), [part2](https://learn.cybertekschool.com/courses/575/pages/018-dot-solution-part2?module_item_id=42203), [part3](https://learn.cybertekschool.com/courses/575/pages/018-dot-solution-part3?module_item_id=42204)


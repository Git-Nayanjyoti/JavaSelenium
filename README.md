
![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white) 
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Apache](https://img.shields.io/badge/apache-%23D42029.svg?style=for-the-badge&logo=apache&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Selenium](https://img.shields.io/badge/-selenium-%43B02A?style=for-the-badge&logo=selenium&logoColor=white)

![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)

# Java Selenium 

Selenium is an open source tool which is used for automating the test’s carried out on different web browsers namely chrome, Firefox, safari and just not the traditional ones. And test’s can be carried out on different OS namely Mac OS, Linux, and Windows. And the selenium test scripts can be integrated with the tools such as TestNG, Junit and so on. for managing test cases and generating reports. It can also be integrated with maven, Jenkins for continuous integration.


This repository will give you an idea of how we can create our own framework for testing Web Applicaions using `Selenium`

## Components of Selenium
- Selenium RC
  - Run test on different browsers and systems
  - Faster than IDE
- Selenium WebDriver
  - Supports multiple browsers
  - Supports multiple OS
  - Supports multiple prog. languages
- Selenium IDE
  - Comes as Firefox plugin and Chrome extension
  - Record and play feature
- Selenium Grid
  - Based on Node & Hub concept
  - Can run multiple tests at once
  - Captures browser screen


```
## Selenium Webdriver Setup
```java
    WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://amzn.to/3EMovJx");
```

## Basic Framework Structure
```java
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
    }

    /**
     * Rigourous Test :-)
     */
    @Test
	public void testApp()
    {
        AssertJUnit.assertTrue( true );
    }
}
```




## Roadmap

- Testing tools for Web Application
- Importing the Dependencies required 
- Writing automation test scripts in java 
    - Test definition(Using BDD)
    ```yaml
    - Given: User is on Homepage
      When: User clicks on login
      Then: User should be logged in

    ```

## Dependencies
- [Cucumber](https://mvnrepository.com/artifact/io.cucumber/cucumber-java)
- [Testng](https://mvnrepository.com/artifact/org.testng/testng)
- [Gherkin](https://mvnrepository.com/artifact/io.cucumber/gherkin)
- [Junit](https://mvnrepository.com/artifact/junit/junit)
- [Selenium](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
## Authors

- [@Nayanjyoti Rabha](https://www.github.com/Git-Nayanjyoti)


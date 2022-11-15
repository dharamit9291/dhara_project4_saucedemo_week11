package com_saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {
    static String browser = "firefox";
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        driver = new EdgeDriver();
        }else{
            System.out.println("Wrong Browser Name");
        }
        //opening url
        driver.get(baseUrl);
        //Maximising the window
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Get the title of the page
        String title = driver.getTitle();
        System.out.println("page title is :" + title);

        // Get current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Get page source
        System.out.println("Page source : " + driver.getPageSource());
        //Find the email field element and send the email
        WebElement emailfield = driver.findElement(By.id("user-name"));
        emailfield.sendKeys("standard_user");

        //Find the password field element and send the password
        WebElement passwordfield = driver.findElement(By.name("password"));
        passwordfield.sendKeys("secret_sauce");

        // Close the browser
        driver.quit();
    }
}

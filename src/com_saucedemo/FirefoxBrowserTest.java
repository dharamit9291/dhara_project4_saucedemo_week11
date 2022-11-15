package com_saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FirefoxBrowserTest {
    public static void main(String[] args) {
        String baseUrl = "https://www.saucedemo.com/";
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        //Launch the URL
        driver.get(baseUrl);
        //Maximise Window
        driver.manage().window().maximize();
        //We give implicit time to driver
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

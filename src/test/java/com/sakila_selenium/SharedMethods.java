package com.sakila_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class SharedMethods {

    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    protected void setUp(@Optional("chrome") String browser) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver",
                        "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                System.out.println("Using Chrome");
                break;
            case "firefox":
                System.setProperty("webdriver.firefox.driver",
                        "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                System.out.println("Using Firefox");
                break;
            default:
                System.out.println("Invalid browser: " + browser +
                        ", defaulting to Chrome instead");
                setUp("chrome");
                break;
        }
        driver.manage()
                .window()
                .maximize();
        System.out.println("Testing set up complete");
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        driver.close();
        driver.quit();
    }

    protected void pause(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    protected void wait(int n) {
        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(n));
    }

    protected void urlCheck(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl,
                "Actual url differs from expected: " + actualUrl);
    }

    protected void checkLink(String startUrl, String linkName,
                             String expectedUrl) {
        driver.get(startUrl);
        driver.findElement(By.linkText(linkName)).click();
        urlCheck(expectedUrl);
        tearDown();
    }

    protected void checkLink(String startUrl, String linkName,
                             String expectedUrl, int waitTime) {
        driver.get(startUrl);
        wait(waitTime);
        driver.findElement(By.linkText(linkName)).click();
        urlCheck(expectedUrl);
        tearDown();
    }
}

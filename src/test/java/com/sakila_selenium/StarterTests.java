package com.sakila_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class StarterTests {

    private final String chosenBrowser = "chrome";
//    private final String chosenBrowser = "firefox";

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
    private void tearDown() {
        driver.quit();
    }

    @Test
    public void clickActorsListTest() {
        System.out.println("\nStarting 'Click actors list' test");

        String url = "http://localhost:5173/";
        driver.get(url);

        driver.findElement(By.linkText("Actors")).click();

        String expectedUrl = "http://localhost:5173/actors";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl,
                "Actual url differs from expected: " + actualUrl);
        System.out.println("Actors link checked");

        wait(2);

        WebElement addActorLink = driver.findElement(By.linkText("Add Actor"));
        Assert.assertTrue(addActorLink.isDisplayed(),
                "Add actors link is not visible");
        System.out.println("Add actors link checked");

        tearDown();
    }

    @Test
    public void clickFilmsListTest() {
        System.out.println("\nStarting 'Click films list' test");

        String url = "http://localhost:5173/";
        driver.get(url);

        driver.findElement(By.linkText("Films")).click();

        String expectedUrl = "http://localhost:5173/films";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl,
                "Actual url differs from expected: " + actualUrl);
        System.out.println("Films link checked");

        wait(2);

        WebElement addFilmLink = driver.findElement(By.linkText("Add Film"));
        Assert.assertTrue(addFilmLink.isDisplayed(),
                "Add films link is not visible");
        System.out.println("Add films link checked");

        tearDown();
    }

    private void pause(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void wait(int n) {
        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(n));
    }

}

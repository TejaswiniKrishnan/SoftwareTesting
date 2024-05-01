package com.example.Testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;
import com.example.PageObject.LoginPage;

public class Baseclass {
    WebDriver driver;
    LoginPage loginPage;
    Logger log = Logger.getLogger(Baseclass.class);

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://www.spencers.in/");
        log.info("Opened the browser and navigated to the website.");
    }

    @Test
    public void testCase1() {
        loginPage.searchProduct("Chocolate");
        loginPage.selectCategory("Dairy & Ice Creams");
        loginPage.addProductToCart();
        loginPage.navigateToCart();
    }

    @Test
    public void testCase2() {
        loginPage.navigateToGroceriesPage();
        loginPage.applyCategoryFilter("Edible Oil");
    }

    @Test
    public void testCase3() {
        loginPage.openLoginPage();
        loginPage.enterInvalidCredentials("testing@gmail.com", "Example20@");

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        log.info("Closed the browser.");
    }
}

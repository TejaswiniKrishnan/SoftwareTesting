package com.example;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
// import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.devtools.v121.indexeddb.model.Key;
// import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    WebDriver driver;
    WebElement table;
    WebElement firstRow;

    @BeforeTest
    public void WebSetup() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://economictimes.indiatimes.com/et-now/results");
    }

    @BeforeMethod
    public void ClickElement() throws InterruptedException {
        WebElement ele = driver.findElement(By.linkText("Mutual Funds"));
        // Thread.sleep(5000);
        ele.click();

    }

    // Thread.sleep(5000);
    @Test
    public void TestExecute() throws Exception, InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        Select dp = new Select(driver.findElement(By.xpath("//*[@id='amcSelection']")));
        dp.selectByVisibleText("Canara Robeco");
        Thread.sleep(2000);
        Select dpb = new Select(driver.findElement(By.name("schemenm")));
        dpb.selectByVisibleText("Canara Robeco Bluechip Equity Direct-G");
        driver.findElement(By.linkText("Get Details")).click();
        String currTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currTab)) {
                driver.switchTo().window(tab);
            }
        }
        driver.findElement(By.xpath("//*[@id='installment_type']/li/i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='installment_type']/li/ul/li[1]/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='installment_amt']/li/i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='installment_amt']/li/ul/li[3]/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='installment_period']/li/i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='installment_period']/li/ul/li[3]/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='mfNav']/div/ul/li[2]")).click();
        Thread.sleep(2000);
        table = driver.findElement(By.xpath("//*[@id='mfReturns']/div[2]/div[2]/ul/li[1]/table"));
        Thread.sleep(2000);
        firstRow = table
                .findElement(By.xpath("//*[@id='mfReturns']/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]"));
    }

    @AfterTest
    public void prints() throws Exception {
        try {
            List<WebElement> cells = firstRow.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                System.out.println(cell.getText() + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(true);

    }
}

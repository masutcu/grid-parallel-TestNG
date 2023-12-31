package tests;

import managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class SearchNumberTest extends DriverManager {
    private WebElement searchElement;



    @Parameters("browser")
    @BeforeClass
    void beforeClass(@Optional("browser") String browser) throws MalformedURLException {
        setDriver(browser);
    }

    @Test
    void searcNumTest1() throws InterruptedException {
        driver.get("https://testrelic.com");
        Thread.sleep(1000);
        searchElement = driver.findElements(By.tagName("input")).get(0);
        searchElement.click();
        searchElement.sendKeys("1");
        searchElement.sendKeys(Keys.ENTER);

    }
    @Test
    void searcNumTest2() throws InterruptedException {
        driver.get("https://testrelic.com");
        Thread.sleep(1000);
        searchElement = driver.findElements(By.tagName("input")).get(0);
        searchElement.click();
        searchElement.sendKeys("2");
        searchElement.sendKeys(Keys.ENTER);

    }
    @AfterClass
    void afterClass(){
        driver.quit();
    }
}

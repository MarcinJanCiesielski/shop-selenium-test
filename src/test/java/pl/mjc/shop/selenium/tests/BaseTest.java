package pl.mjc.shop.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.mjc.shop.selenium.utils.DriverFactory;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    
    @BeforeMethod
    public void beforeMethode(){
        driver = DriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://seleniumdemo.com");
    }
    
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    
}

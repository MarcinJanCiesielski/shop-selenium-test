package pl.mjc.shop.selenium.tests;

import org.testng.annotations.Test;

public class SearchProductTest extends BaseTest {
    @Test
    public void openPage() {
        driver.get("http://seleniumdemo.com/");
    }
}

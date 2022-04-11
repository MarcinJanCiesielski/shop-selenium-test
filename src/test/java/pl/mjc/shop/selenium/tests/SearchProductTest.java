package pl.mjc.shop.selenium.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.mjc.shop.selenium.pages.HomePage;
import pl.mjc.shop.selenium.pages.SearchProductPage;
import pl.mjc.shop.selenium.pages.SearchProductResultsPage;

import java.util.List;

public class SearchProductTest extends BaseTest {
    @Test
    public void searchProductTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSearchButton();
        
        SearchProductPage searchProductPage = new SearchProductPage(driver);
        searchProductPage.performSearch("git");
        
        SearchProductResultsPage resultsPage = new SearchProductResultsPage(driver);
        try {
            Thread.sleep(3000);
        }
        catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<String> products = resultsPage.getProducts()
                                           .stream()
                                            .filter(WebElement::isDisplayed)
                                           .map(WebElement::getText)
                                           .toList();
        Assert.assertTrue(products.contains("GIT basics"));
    }
}

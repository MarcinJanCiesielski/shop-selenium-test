package pl.mjc.shop.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchProductResultsPage {
    @FindBy(css = "a.czr-title")
    List<WebElement> products;
    
    public SearchProductResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    public List<WebElement> getProducts() {
        return products;
    }
}

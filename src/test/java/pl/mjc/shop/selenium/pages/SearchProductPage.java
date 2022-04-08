package pl.mjc.shop.selenium.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchProductPage {
    @FindBy(name = "s")
    List<WebElement> searchInput;
    
    public SearchProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    public void performSearch(String search) {
        searchInput
            .stream()
                .filter(WebElement::isDisplayed)
                    .findFirst()
                .ifPresent(el -> el.sendKeys(search + Keys.ENTER));
    }
}

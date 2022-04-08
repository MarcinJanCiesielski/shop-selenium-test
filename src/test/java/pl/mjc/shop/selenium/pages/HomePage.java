package pl.mjc.shop.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    
    @FindBy(xpath = "//a[@class='search-toggle_btn icn-search czr-overlay-toggle_btn']")
    WebElement searchButton;
    
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    public void clickSearchButton() {
        searchButton.click();
    }
}

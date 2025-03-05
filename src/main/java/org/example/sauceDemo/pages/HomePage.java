package org.example.sauceDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//select[@data-test=\"product-sort-container\"]")
    private WebElement selector;

    @FindBy(xpath = "//option[@value=\"lohi\"]")
    private WebElement option;

    @FindBy(xpath = "//div[@data-test=\"inventory-item-price\"]")
    private List<WebElement> prices;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void changeOption(){
        selector.click();
        option.click();
    }

    public List<WebElement> getPrices() {
        return prices;
    }
}

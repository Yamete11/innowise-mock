package org.innowise.selenium.sauceDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//select[@data-test=\"product-sort-container\"]")
    private WebElement selector;

    @FindBy(xpath = "//option[@value=\"lohi\"]")
    private WebElement option;

    @FindBy(className = "inventory_item_price")
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

    public List<Double> extractPrices() {
        return prices.stream()
                .map(price -> price.getText().replace("$", "").trim())
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}

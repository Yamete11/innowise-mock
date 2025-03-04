package org.example.nhl.pages;

import org.example.nhl.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//h5[contains(text(), \"Top Stories\")]")
    private WebElement text;

    @FindBy(className = "nhl-c-header")
    private Header headerMenu;

    @FindBy(xpath = "//button[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement acceptCookieButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookies() {
        acceptCookieButton.click();
    }

    public WebElement getText() {
        return text;
    }

    public WebElement getAcceptCookieButton() {
        return acceptCookieButton;
    }
}

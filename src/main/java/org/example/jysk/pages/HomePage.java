package org.example.jysk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//button[@aria-label=\"Akceptuj wszystkie\"]")
    private WebElement acceptCookies;

    @FindBy(xpath = "//span[contains(text(), \"Wybierz swój sklep JYSK\")]")
    private WebElement checkText;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(acceptCookies));
        acceptCookiesButton.click();
    }

    public WebElement getCheckText() {
        return checkText;
    }
}

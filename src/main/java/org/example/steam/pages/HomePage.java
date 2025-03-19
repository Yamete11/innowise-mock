package org.example.steam.pages;

import org.example.steam.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private Header header;

    @FindBy(id = "noteworthy_tab")
    private WebElement newNoteWorthy;

    @FindBy(xpath = "//div[@id=\"noteworthy_flyout\"]//a[contains(text(), \"Top Sellers\")]")
    private WebElement topSellers;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.header = new Header(driver);
        PageFactory.initElements(driver, this);
    }

    public Header getHeader() {
        return header;
    }

    public void clickOnNewNoteWorthy() {
        Actions action = new Actions(driver);
        action.moveToElement(newNoteWorthy)
                .perform();
    }

    public void openTopSellers(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement aboutButton = wait.until(ExpectedConditions.elementToBeClickable(topSellers));
        aboutButton.click();
    }
}

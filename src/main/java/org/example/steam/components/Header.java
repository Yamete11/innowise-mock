package org.example.steam.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(), 'About') and @href=\"https://store.steampowered.com/about/?snr=1_4_4__global-header\"]")
    private WebElement aboutButton;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAbout() {
        aboutButton.click();
    }

    public WebElement getAboutButton() {
        return aboutButton;
    }
}

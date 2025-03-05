package org.example.steam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GamePage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@id=\"appHubAppName\"]")
    private WebElement title;

    @FindBy(xpath = "//div[@class=\"game_area_purchase_game  \"]//div[@class=\"game_purchase_price price\"]")
    private WebElement price;

    @FindBy(xpath = "//div[@class=\"date\"]")
    private WebElement releaseDate;

    @FindBy(xpath = "//a[@href=\"https://store.steampowered.com/tags/en/FPS/?snr=1_5_9__409\"]")
    private WebElement mainGenre;

    @FindBy(xpath = "//a[@href=\"https://store.steampowered.com/developer/valve?snr=1_5_9__2000\"]")
    private WebElement developer;


    public GamePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getPrice() {
        return price;
    }

    public WebElement getReleaseDate() {
        return releaseDate;
    }

    public WebElement getMainGenre() {
        return mainGenre;
    }

    public WebElement getDeveloper() {
        return developer;
    }
}

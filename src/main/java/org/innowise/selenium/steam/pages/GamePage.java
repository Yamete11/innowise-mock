package org.innowise.selenium.steam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GamePage {

    private WebDriver driver;

    @FindBy(id = "appHubAppName")
    private WebElement title;

    @FindBy(xpath = "//div[@class=\"game_purchase_action\"]//div[@class=\"game_purchase_price price\"]")
    private WebElement price;

    @FindBy(className = "date")
    private WebElement releaseDate;

    @FindBy(xpath = "//a[@class=\"app_tag\" and @style=\"\"]")
    private List<WebElement> mainGenre;

    @FindBy(id = "developers_list")
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

    public List<WebElement> getMainGenre() {
        return mainGenre;
    }

    public WebElement getDeveloper() {
        return developer;
    }
}

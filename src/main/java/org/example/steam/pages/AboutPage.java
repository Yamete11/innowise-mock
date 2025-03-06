package org.example.steam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='online_stat_label gamers_online']/..")
    private WebElement onlinePlayers;

    @FindBy(xpath = "//div[@class='online_stat_label gamers_in_game']/..")
    private WebElement playingPlayers;


    public AboutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkDifference(){
        int online = extractNumber(onlinePlayers);
        int playing = extractNumber(playingPlayers);
        return online > playing;
    }

    public int extractNumber(WebElement element) {
        return Integer.parseInt(element.getText().replaceAll("[^0-9]", ""));
    }


    public WebElement getOnlinePlayers() {
        return onlinePlayers;
    }

    public WebElement getPlayingPlayers() {
        return playingPlayers;
    }
}

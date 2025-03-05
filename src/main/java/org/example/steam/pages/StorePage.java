package org.example.steam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StorePage {

    private WebDriver driver;


    @FindBy(xpath = "//button[@class=\"DialogDropDown _DialogInputContainer  Focusable\"]")
    private WebElement dialogButton;



    public StorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void changeCountry(String country){
        WebDriverWait waitDialog = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitDialog.until(ExpectedConditions.elementToBeClickable(dialogButton));
        dialogButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement countryOption = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='_2oAiZidGyUxL-hfupFDQ2m']/div[contains(text(), '" + country + "')]/.."))));

        Actions action = new Actions(driver);
        action.moveToElement(countryOption).click().perform();
    }

    public List<WebElement> collectGames(int quantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tr[@class=\"_2-RN6nWOY56sNmcDHu069P\"]")));

        List<WebElement> allItems = driver.findElements(By.xpath("//tr[@class=\"_2-RN6nWOY56sNmcDHu069P\"]"));

        return allItems.size() > quantity ? allItems.subList(0, quantity) : allItems;
    }

    public String extractTitle(WebElement element){
        return element.findElement(By.xpath("//div[@class=\"_1n_4-zvf0n4aqGEksbgW9N\"]")).getText();
    }

    public String extractPrice(WebElement element){
        return element.findElement(By.xpath("//div[@class=\"_3j4dI1yA7cRfCvK8h406OB\"]")).getText();

    }
}

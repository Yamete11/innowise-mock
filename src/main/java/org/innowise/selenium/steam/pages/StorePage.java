package org.innowise.selenium.steam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StorePage {

    private WebDriver driver;

    @FindBy(xpath = "//button[contains(@class, \"DialogDropDown _DialogInputContainer\")]")
    private WebElement filterButton;



    public StorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void changeCountry(String country){
        WebDriverWait waitDialog = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitDialog.until(ExpectedConditions.elementToBeClickable(filterButton));
        filterButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement countryOption = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='_2oAiZidGyUxL-hfupFDQ2m']/div[contains(text(), '" + country + "')]/.."))));

        Actions action = new Actions(driver);
        action.moveToElement(countryOption).click().perform();
    }

    public List<WebElement> collectGames(int quantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='N8w56WjrQPSB3M6hVSXDx']")));

        return driver.findElements(By.xpath("//div[@class='N8w56WjrQPSB3M6hVSXDx']"))
                .stream()
                .limit(quantity)
                .toList();
    }



    public String extractTitle(WebElement element){
        return element.findElement(By.xpath("//div[@class=\"_1n_4-zvf0n4aqGEksbgW9N\"]")).getText();
    }

    public String extractPrice(WebElement element){
        return element.findElement(By.xpath("//div[@class=\"_3j4dI1yA7cRfCvK8h406OB\"]")).getText();

    }
}

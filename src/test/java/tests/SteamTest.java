package tests;

import org.example.steam.pages.AboutPage;
import org.example.steam.pages.GamePage;
import org.example.steam.pages.HomePage;
import org.example.steam.pages.StorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SteamTest {

    WebDriver driver;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://store.steampowered.com/");
    }

    @Test
    public void testFirstCase(){
        HomePage homePage = new HomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement aboutButton = wait.until(ExpectedConditions.elementToBeClickable(homePage.getHeader().getAboutButton()));
        aboutButton.click();

        AboutPage aboutPage = new AboutPage(driver);

        assertTrue(aboutPage.countDifference(), "Playing players more then online");
    }

    @Test
    public void testSecondCase(){
        HomePage homePage = new HomePage(driver);

        homePage.clickOnNewNoteWorthy();
        homePage.openTopSellers();

        StorePage storePage = new StorePage(driver);

        storePage.changeCountry("Global");

        List<WebElement> gamesList = storePage.collectGames(10);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(gamesList.get(0)));
        String title = storePage.extractTitle(gamesList.get(0));
        String price = storePage.extractPrice(gamesList.get(0));
        gamesList.get(0).click();

        GamePage gamePage = new GamePage(driver);

        assertEquals(gamePage.getTitle().getText(), title, "Title is wrong");
        assertEquals(gamePage.getPrice().getText(), price, "Price is wrong");


        System.out.println("Release date: " + gamePage.getReleaseDate().getText());
        System.out.println("Main genre: " + gamePage.getMainGenre().getText());
        System.out.println("Developer: " + gamePage.getDeveloper().getText());

    }

}

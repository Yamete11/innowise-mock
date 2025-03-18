package tests;

import org.example.steam.model.GameInfo;
import org.example.steam.pages.AboutPage;
import org.example.steam.pages.GamePage;
import org.example.steam.pages.HomePage;
import org.example.steam.pages.StorePage;
import org.example.utils.P;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.TestUtils;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SteamTest extends BaseTest {


    @BeforeMethod
    public void openPage() {
        driver.get(P.CONFIG("steamUrl"));
        driver.manage().window().maximize();
    }

    @Test
    public void testCompareNumberOfPlayers(){
        HomePage homePage = new HomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement aboutButton = wait.until(ExpectedConditions.elementToBeClickable(homePage.getHeader().getAboutButton()));
        aboutButton.click();

        AboutPage aboutPage = new AboutPage(driver);

        assertTrue(aboutPage.getPageTitle().isDisplayed(), "Page title is not displayed");
        assertTrue(aboutPage.checkDifference(), "Playing players more then online");
    }

    @Test
    public void testGetTopSellers(){
        HomePage homePage = new HomePage(driver);

        homePage.clickOnNewNoteWorthy();
        homePage.openTopSellers();

        StorePage storePage = new StorePage(driver);

        storePage.changeCountry("Global");

        List<WebElement> gamesList = storePage.collectGames(10);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(gamesList.get(0)));

        GameInfo gameInfo = new GameInfo(
                storePage.extractTitle(gamesList.get(0)),
                TestUtils.extractPrice(storePage.extractPrice(gamesList.get(0)))
        );

        gamesList.get(0).click();

        GamePage gamePage = new GamePage(driver);

        assertEquals(gamePage.getTitle().getText(), gameInfo.getTitle(), "Title is wrong");
        assertEquals(gameInfo.getPrice(), TestUtils.extractPrice(gamePage.getPrice().getText()), "Price is wrong");


        logger.info("Release date: {}", gamePage.getReleaseDate().getText());
        gamePage.getMainGenre().forEach(genre -> {
            logger.info("Genre: {}", genre.getText());
        });
        logger.info("Developer: {}", gamePage.getDeveloper().getText());
    }

}

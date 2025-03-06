package tests;

import org.example.sauceDemo.pages.HomePage;
import org.example.sauceDemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SauceDemoTest extends BaseTest {

    @BeforeClass
    public void openPage() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

    }


    @Test
    public void testOfSorting() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage = new HomePage(driver);
        homePage.changeOption();

        homePage.getPrices().forEach(price -> {
            logger.info("Price: {}", price.getText());
        });

        assertTrue(TestUtils.isSortedAsc(homePage.extractPrices()), "List is not sorted correctly");
    }
}

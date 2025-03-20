package tests;

import org.innowise.selenium.sauceDemo.pages.HomePage;
import org.innowise.selenium.sauceDemo.pages.LoginPage;
import org.innowise.utils.P;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.TestUtils;

import static org.testng.Assert.assertTrue;

public class SauceDemoTest extends BaseTest {

    @BeforeClass
    public void openPage() {
        driver.get(P.CONFIG("sauceDemoUrl"));
    }


    @Test
    public void testOfSorting(){
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

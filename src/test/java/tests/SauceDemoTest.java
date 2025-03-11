package tests;

import org.example.annotations.MethodOwner;
import org.example.annotations.Priority;
import org.example.annotations.LEVEL;
import org.example.sauceDemo.pages.HomePage;
import org.example.sauceDemo.pages.LoginPage;
import org.example.utils.P;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.TestUtils;

import static org.testng.Assert.assertTrue;

public class SauceDemoTest extends BaseTest {

    @BeforeClass
    public void openPage() {
        driver.get(P.CONFIG("sauceDemoUrl"));
        driver.manage().window().maximize();

    }


    @Test
    @MethodOwner("Gleb")
    @Priority(LEVEL.P2)
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

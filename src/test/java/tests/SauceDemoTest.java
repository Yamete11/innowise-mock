package tests;

import org.example.sauceDemo.pages.HomePage;
import org.example.sauceDemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SauceDemoTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testOfSorting() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage = new HomePage(driver);
        homePage.changeOption();

        homePage.getPrices().stream().forEach(price -> {
            System.out.println(price.getText());
        });

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

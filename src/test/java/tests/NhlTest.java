package tests;

import org.example.nhl.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NhlTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.nhl.com/");
    }

    @Test
    public void testMainPage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        Thread.sleep(5000);

        homePage.getAcceptCookieButton().click();


        //String text = homePage.getText().getText();

        //assertEquals(text, "Top Stories", "text is not the same");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

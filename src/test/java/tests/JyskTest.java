package tests;

import org.example.jysk.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JyskTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jysk.pl/");
    }

    @Test
    public void testMainPage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        homePage.acceptCookies();

        String text = homePage.getCheckText().getText();

        assertEquals(text, "Wybierz swój sklep JYSK", "text is not the same");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

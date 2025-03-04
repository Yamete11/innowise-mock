package tests;

import org.example.nhl.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

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

        WebElement text = driver.findElement(By.xpath("//h5[contains(text(), \"Top Stories\")]"));
        Thread.sleep(5000);

        assertEquals(homePage.getText().getText(), "Top Stories", "text is not the same");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

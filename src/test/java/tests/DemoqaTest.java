package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoqaTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void testSendingForm(){

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

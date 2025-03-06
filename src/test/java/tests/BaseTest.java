package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        logger.info("Driver initialized");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        logger.info("Driver quit");
    }

}

package tests;

import org.example.strategy.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class BaseTest {

    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;


    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        logger.info("Received browser parameter: {}", browser);
        BrowserStrategy strategy;

        if ("chrome".equalsIgnoreCase(browser)) {
            strategy = new ChromeStrategy();
        } else if ("edge".equalsIgnoreCase(browser)) {
            strategy = new EdgeStrategy();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            strategy = new FireFoxStrategy();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver = new BrowserContext(strategy).getDriver();
        logger.info("Initialized {} driver", browser);
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Driver quit");
        }
    }
}


package tests;

import org.example.demoqa.pages.HomePage;
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
        HomePage.FormBuilder formBuilder = new HomePage.FormBuilder(driver);
        formBuilder
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john.doe@gmail.com")
                //.setGender()
                .setPhoneNumber("12345678910")
                //.setHobby()
                .setAddress("Hello There")
                .setState()
                .setCity()
                .submit();


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

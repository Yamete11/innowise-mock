package tests;

import org.example.demoqa.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DemoqaTest extends BaseTest {


    @BeforeClass
    public void openPage() {
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
    }

    @DataProvider(name = "formData")
    public Object[][] provideFormData() {
        return new Object[][] {
                { "John", "Doe", "john.doe@gmail.com", "Male", "12345671230", "Maths", "Hello There", true },
                { "John", "Doe", "john.doe@gmail.com", "Male", "1", "Maths", "Hello There", false },
                { "John", "", "john.doe@gmail.com", "Male", "12345671230", "Maths", "Hello There", false },
                { "", "Doe", "john.doe@gmail.com", "Male", "12345671230", "Maths", "Hello There", false },
                { "John", "Doe", "john.doe@gmail.com", "", "12345671230", "Maths", "Hello There", false },
        };
    }

    @Test(dataProvider = "formData")
    public void testSendingForm(String firstName, String lastName, String email, String gender, String phoneNumber, String subject, String address, boolean success) {
        HomePage.FormBuilder formBuilder = new HomePage.FormBuilder(driver);
        formBuilder
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setSubject(subject)
                .setHobby()
                .setChoosePicture()
                .setAddress(address)
                .setState()
                .setCity()
                .submit();

        HomePage homePage = new HomePage(driver);

        if (success) {
            assertTrue(homePage.isSuccessNotificationPresent(), "Success Notification is not displayed");
        } else {
            assertFalse(homePage.isSuccessNotificationPresent(), "Success Notification is displayed but should not be");
        }
    }

    @AfterMethod
    public void cleanUp() {
        driver.navigate().refresh();
    }
}

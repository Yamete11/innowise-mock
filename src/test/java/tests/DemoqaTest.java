package tests;

import org.example.demoqa.pages.HomePage;
import org.example.utils.P;
import org.testng.annotations.*;
import utils.TestUtils;

import java.io.File;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DemoqaTest extends BaseTest {

    String filePath = new File(P.CONFIG("picture")).getAbsolutePath();

    @BeforeClass
    public void openPage() {
        driver.get(P.CONFIG("demoqaUrl"));
        driver.manage().window().maximize();
    }

    @DataProvider(name = "formData")
    public Object[][] provideFormData() {
        return new Object[][] {
                { "John", "Doe", "john.doe@gmail.com", "Male", "1234567123", "29 December,2024", "Maths", "Sports", filePath, "Hello There", true },
                { "John", "Doe", "john.doe@gmail.com", "Male", "1", "20 November,2025", "Maths", "Sports", filePath, "Hello There", false },
                { "John", "", "john.doe@gmail.com", "Male", "1234567123", "25 December,2024", "Maths", "Sports", filePath, "Hello There", false },
                { "", "Doe", "john.doe@gmail.com", "Male", "1234567123", "16 August,2024", "Maths", "Sports", filePath, "Hello There", false },
                { "John", "Doe", "john.doe@gmail.com", "", "1234567123", "23 October,2024", "Maths", "Sports", filePath, "Hello There", false },
        };
    }

    @Test(dataProvider = "formData")
    public void testSendingForm(String firstName, String lastName, String email, String gender, String phoneNumber, String dateOfBirth, String subject, String hobby, String picture, String address, boolean success) throws InterruptedException {
        HomePage.FormBuilder formBuilder = new HomePage.FormBuilder(driver);
        HomePage homePage = formBuilder.getHomePage();
        formBuilder
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setDateOfBirth(dateOfBirth)
                .setSubject(subject)
                .setHobby(hobby)
                .setChoosePicture(picture)
                .setAddress(address)
                .setState()
                .setCity()
                .submit();

        Thread.sleep(5000);

        if (success) {
            assertTrue(homePage.getForm().isSuccessNotificationPresent(), "Success Notification is not displayed");
            assertTrue(homePage.getForm().verifyFormData(firstName + " " + lastName, email, gender, phoneNumber, dateOfBirth, subject, hobby, TestUtils.getFileName(picture), address), "Data does not match");
        } else {
            assertFalse(homePage.getForm().isSuccessNotificationPresent(), "Success Notification is displayed but should not be");
        }
    }

    @AfterMethod
    public void cleanUp() {
        driver.navigate().refresh();
    }
}

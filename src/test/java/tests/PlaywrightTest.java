package tests;

import com.microsoft.playwright.*;
import org.innowise.playwright.*;
import org.innowise.utils.P;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class PlaywrightTest {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;
    String filePath = new File(P.CONFIG("picture")).getAbsolutePath();


    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(2200, 1200));
    }

    @DataProvider(name = "textBoxData")
    public Object[][] getData() {
        return new Object[][]{
                {"My name", "myEmail@my.com", "CurrentAddress", "PermAddress"},
                {"Your name", "yourEmail@my.com", "NewAddress", "NewAddress"},
        };
    }

    @Test(dataProvider = "textBoxData")
    public void testFillTextBoxForm(String fullName, String email, String currentAddress, String permanentAddress) {
        page = context.newPage();

        TextBoxPage textBoxPage = new TextBoxPage(page);

        page.navigate("https://demoqa.com/text-box");

        textBoxPage.fillForm(fullName, email, currentAddress, permanentAddress);

        textBoxPage.submitForm();

        assertTrue(textBoxPage.isOutputVisible(), "Output is not visible!");

        String outputText = textBoxPage.getOutputText();
        assertTrue(outputText.contains(fullName), "Full name is missing");
        assertTrue(outputText.contains(email), "Email is missing");
        assertTrue(outputText.contains(currentAddress), "Current address is missing");
        assertTrue(outputText.contains(permanentAddress), "Permanent address is missing");
    }

    @DataProvider(name = "formData")
    public Object[][] getFormData(){
        return new Object[][]{
                {"My first name", "My last name", "myEmail@my.com", "Male", "1234567890", "29 December,2024", "Maths", "Sports", "CurrentAddress", "NCR", "Delhi", filePath, true},
                {"Your first name", "Your last name", "yourEmail@my.com", "Female", "1234567890", "27 November,2024", "Maths", "Reading", "CurrentAddress", "Haryana", "Karnal", filePath, true},
        };
    }

    @Test(dataProvider = "formData")
    public void testSendingForm(String firstName, String lastName, String email, String gender, String mobile,
                                String dateOfBirth, String subject, String hobby, String currentAddress,
                                String state, String city, String file, boolean success) throws InterruptedException {
        page = context.newPage();
        FormPage formPage = new FormPage(page);
        page.navigate("https://demoqa.com/automation-practice-form");

        formPage.fillForm(firstName, lastName, email, gender, mobile, dateOfBirth, subject, hobby, currentAddress, state, city, file);
        formPage.submit();

        FormInfo formInfo = new FormInfo(page);

        boolean result = formInfo.verifyFormData(
                firstName + " " + lastName,
                email,
                gender,
                mobile,
                dateOfBirth,
                subject,
                hobby,
                currentAddress,
                state + " " + city,
                TestUtils.getFileName(file)
        );
        if (success) {
            assertTrue(result, "Data is not the same as expected");
        }
    }


    @Test
    public void testingSorting(){
        page = context.newPage();
        page.navigate("https://www.saucedemo.com/");
        SauceLoginPage sauceLoginPage = new SauceLoginPage(page);

        sauceLoginPage.fillForm("standard_user", "secret_sauce");
        sauceLoginPage.logIn();

        SauceHomePage sauceHomePage = new SauceHomePage(page);
        sauceHomePage.selectSortingOption("lohi");

        List<Double> prices = sauceHomePage.getAllPrices();

        List<Double> sortedPrices = prices.stream()
                .sorted().collect(Collectors.toList());

        assertEquals(sortedPrices, prices);
    }

    @Test
    public void testProblematicUser(){
        page = context.newPage();
        page.navigate("https://www.saucedemo.com/");
        SauceLoginPage sauceLoginPage = new SauceLoginPage(page);

        sauceLoginPage.fillForm("standard_user", "secret_sauce");
        sauceLoginPage.logIn();

        SauceHomePage sauceHomePage = new SauceHomePage(page);
    }

    @AfterClass
    public void tearDown() {
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}

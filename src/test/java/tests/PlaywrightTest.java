package tests;

import com.microsoft.playwright.*;
import org.example.playwright.FormPage;
import org.example.playwright.SauceHomePage;
import org.example.playwright.SauceLoginPage;
import org.example.playwright.TextBoxPage;
import org.example.utils.P;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
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
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
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
                {"My  first name", "My last name", "myEmail@my.com", "Male", "1234567890", "Maths", "Sports", "CurrentAddress", filePath},
                {"Your first name", "Your lastEmail", "yourEmail@my.com", "Female", "1234567890", "Maths", "Reading", "CurrentAddress", filePath},
        };
    }

    @Test(dataProvider = "formData")
    public void testSendingForm(String firstName, String lastName, String email, String gender, String mobile, String subject, String hobby, String currentAddress, String file) throws InterruptedException {
        page = context.newPage();
        FormPage formPage = new FormPage(page);
        page.navigate("https://demoqa.com/automation-practice-form");

        formPage.fillForm(firstName, lastName, email, gender, mobile, subject, hobby, currentAddress, file);
        formPage.submit();
        Thread.sleep(5000);
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

package org.example.demoqa.pages;

import org.example.demoqa.components.Form;
import org.example.steam.components.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Paths;
import java.security.interfaces.XECPrivateKey;
import java.time.Duration;
import java.util.Objects;

public class HomePage {

    private WebDriver driver;

    private Form form;

    String filePath = new File("src/main/resources/test3.jpg").getAbsolutePath();


    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "userEmail")
    private WebElement email;

    @FindBy(id = "userNumber")
    private WebElement phoneNumber;

    @FindBy(id = "subjectsContainer")
    private WebElement subject;

    @FindBy(id = "subjectsInput")
    private WebElement subjectInput;

    @FindBy(id = "react-select-2-option-0")
    private WebElement subjectOption;

    @FindBy(id = "hobbiesWrapper")
    private WebElement hobby;

    @FindBy(id = "uploadPicture")
    private WebElement choosePictureButton;

    @FindBy(id = "currentAddress")
    private WebElement address;

    @FindBy(id = "state")
    private WebElement selectState;

    @FindBy(id = "react-select-3-option-0")
    private WebElement ncr;

    @FindBy(id = "city")
    private WebElement selectCity;

    @FindBy(id = "react-select-4-option-0")
    private WebElement delhi;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.form = new Form(driver);
        PageFactory.initElements(driver, this);
    }


    public Form getForm() {
        return form;
    }

    public static class FormBuilder {
        private WebDriver driver;
        private HomePage homePage;

        public FormBuilder(WebDriver driver) {
            this.driver = driver;
            this.homePage = new HomePage(driver);
        }

        public FormBuilder setFirstName(String firstName) {
            homePage.firstName.sendKeys(firstName);
            return this;
        }

        public FormBuilder setLastName(String lastName) {
            homePage.lastName.sendKeys(lastName);
            return this;
        }

        public FormBuilder setEmail(String email) {
            homePage.email.sendKeys(email);
            return this;
        }

        public FormBuilder setPhoneNumber(String phoneNumber) {
            homePage.phoneNumber.sendKeys(phoneNumber);
            return this;
        }

        public FormBuilder setGender(String gender) {
            String genderXPath = String.format("//label[contains(text(), \"%s\")]", gender);
            WebElement genderElement = driver.findElement(By.xpath(genderXPath));
            genderElement.click();
            return this;
        }

        public FormBuilder setSubject(String subject) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.elementToBeClickable(homePage.subject));
            homePage.subject.click();
            homePage.subjectInput.sendKeys(subject);

            wait.until(ExpectedConditions.elementToBeClickable(homePage.subjectOption));
            homePage.subjectOption.click();
            return this;
        }

        public FormBuilder setHobby(String hobbyToSelect) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(homePage.hobby));

            String hobbyXPath = String.format("//label[contains(text(), '%s')]", hobbyToSelect);

            WebElement hobbyElement = driver.findElement(By.xpath(hobbyXPath));
            hobbyElement.click();

            return this;
        }


        public FormBuilder setChoosePicture() {
            homePage.choosePictureButton.sendKeys(homePage.filePath);
            return this;
        }

        public FormBuilder setAddress(String address) {
            homePage.address.sendKeys(address);
            return this;
        }

        public FormBuilder setState() {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(Exception.class);

            wait.until(driver -> {
                try {
                    homePage.selectState.click();
                    homePage.ncr.click();
                    return true;
                } catch (Exception e) {
                    return false;
                }
            });

            return this;
        }


        public FormBuilder setCity() {
            homePage.selectCity.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(homePage.delhi));
            homePage.delhi.click();
            return this;
        }


        public void submit() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(homePage.submitButton));
            homePage.submitButton.click();
        }

        public HomePage getHomePage() {
            return homePage;
        }

    }

}

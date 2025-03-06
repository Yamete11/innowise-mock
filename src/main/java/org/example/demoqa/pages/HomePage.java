package org.example.demoqa.pages;

import org.example.steam.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.interfaces.XECPrivateKey;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id=\"firstName\"]")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id=\"lastName\"]")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id=\"userEmail\"]")
    private WebElement email;

    @FindBy(xpath = "//input[@id=\"userNumber\"]")
    private WebElement phoneNumber;

    @FindBy(xpath = "//input[@id=\"dateOfBirthInput\"]")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//input[@value=\"Male\"]")
    private WebElement gender;

    @FindBy(xpath = "//input[@id=\"hobbies-checkbox-1\"]")
    private WebElement hobby;

    @FindBy(xpath = "//textarea[@id=\"currentAddress\"]")
    private WebElement address;

    @FindBy(xpath = "//div[@class=\" css-yk16xz-control\"]")
    private WebElement selectState;

    @FindBy(xpath = "//div[@id=\"react-select-3-option-0\"]")
    private WebElement ncr;

    @FindBy(xpath = "//div[@class=\" css-yk16xz-control\"]")
    private WebElement selectCity;

    @FindBy(xpath = "//div[@id=\"react-select-4-option-0\"]")
    private WebElement delhi;

    @FindBy(xpath = "//button[@id=\"submit\"]")
    private WebElement submitButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

        public FormBuilder setGender() {
            homePage.gender.click();
            return this;
        }

        public FormBuilder setHobby() {
            homePage.hobby.click();
            return this;
        }

        public FormBuilder setAddress(String address) {
            homePage.address.sendKeys(address);
            return this;
        }

        public FormBuilder setState() {
            homePage.selectState.click();
            homePage.ncr.click();
            return this;
        }

        public FormBuilder setCity() {
            homePage.selectCity.click();
            homePage.delhi.click();
            return this;
        }

        public void submit() {
            homePage.submitButton.click();
        }
    }

}

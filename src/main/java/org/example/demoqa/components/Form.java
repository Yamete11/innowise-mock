package org.example.demoqa.components;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Form {

    private WebDriver driver;

    @FindBy(xpath = "//td[text()='Student Name']/following-sibling::td\n")
    private WebElement fullName;

    @FindBy(xpath = "//td[text()='Student Email']/following-sibling::td\n")
    private WebElement email;

    @FindBy(xpath = "//td[text()='Gender']/following-sibling::td\n")
    private WebElement gander;

    @FindBy(xpath = "//td[text()='Mobile']/following-sibling::td\n")
    private WebElement mobile;

    @FindBy(xpath = "//td[text()='Date of Birth']/following-sibling::td\n")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//td[text()='Subjects']/following-sibling::td\n")
    private WebElement subjects;

    @FindBy(xpath = "//td[text()='Hobbies']/following-sibling::td\n")
    private WebElement hobby;

    @FindBy(xpath = "//td[text()='Picture']/following-sibling::td\n")
    private WebElement picture;

    @FindBy(xpath = "//td[text()='Address']/following-sibling::td\n")
    private WebElement address;

    @FindBy(xpath = "//td[text()='State and City']/following-sibling::td\n")
    private WebElement stateAndCity;

    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement successNotification;


    public Form(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isSuccessNotificationPresent() {
        try {
            return successNotification.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean verifyFormData(String expectedName, String expectedEmail, String expectedGender, String expectedPhone, String expectedSubject, String expectedHobby, String expectedPicture, String expectedAddress) {
        return fullName.getText().equals(expectedName)
                && email.getText().equals(expectedEmail)
                && gander.getText().equals(expectedGender)
                && mobile.getText().equals(expectedPhone)
                && subjects.getText().contains(expectedSubject)
                && hobby.getText().equals(expectedHobby)
                && picture.getText().equals(expectedPicture)
                && address.getText().equals(expectedAddress);
    }


    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getFullName() {
        return fullName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getGander() {
        return gander;
    }

    public WebElement getMobile() {
        return mobile;
    }

    public WebElement getDateOfBirth() {
        return dateOfBirth;
    }

    public WebElement getSubjects() {
        return subjects;
    }

    public WebElement getHobby() {
        return hobby;
    }

    public WebElement getPicture() {
        return picture;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getStateAndCity() {
        return stateAndCity;
    }
}

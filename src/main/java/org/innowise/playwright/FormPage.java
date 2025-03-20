package org.innowise.playwright;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class FormPage {

    private final Page page;
    private final Locator firstName;
    private final Locator lastName;
    private final Locator email;
    private final Locator mobile;
    private final Locator dateOfBirth;
    private final Locator subjectInput;
    private final Locator subjectOption;
    private final Locator currentAddress;
    private final Locator choosePicture;
    private final Locator selectState;
    private final Locator selectCity;
    private final Locator submitButton;


    public FormPage(Page page) {
        this.page = page;
        this.firstName = page.locator("#firstName");
        this.lastName = page.locator("#lastName");
        this.email = page.locator("#userEmail");
        this.mobile = page.locator("#userNumber");
        this.dateOfBirth = page.locator("#dateOfBirthInput");
        this.subjectInput = page.locator("#subjectsInput");
        this.subjectOption = page.locator("#react-select-2-option-0");
        this.currentAddress = page.locator("#currentAddress");
        this.choosePicture = page.locator("#uploadPicture");
        this.selectState = page.locator("#state");
        this.selectCity = page.locator("#city");
        this.submitButton = page.locator("#submit");
    }

    public void fillForm(String firstName, String lastName, String email, String gender, String mobile, String dateOfBirth,
                         String subject, String hobby, String currentAddress, String state, String city, String file) throws InterruptedException {
        this.firstName.fill(firstName);
        this.lastName.fill(lastName);
        this.email.fill(email);
        selectGender(gender);
        this.mobile.fill(mobile);

        this.dateOfBirth.press("Control+A");
        this.dateOfBirth.fill(dateOfBirth);

        this.subjectInput.fill(subject);
        this.subjectOption.waitFor();
        this.subjectOption.click();

        selectHobby(hobby);
        this.currentAddress.fill(currentAddress);

        choosePicture(file);

        this.selectState.click();
        selectState(state);

        this.selectCity.click();
        selectCity(city);
    }

    public void submit() {
        submitButton.click();
    }

    public void selectGender(String gender) {
        String genderLocator = String.format("//label[contains(text(), \"%s\")]", gender);
        page.locator(genderLocator).click();
    }

    public void selectHobby(String hobby) {
        String hobbyLocator = String.format("//label[contains(text(), \"%s\")]", hobby);
        page.locator(hobbyLocator).click();
    }

    public void selectState(String state) {
        String stateLocator = String.format("//div[@id=\"state\"]//div[contains(text(), \"%s\")]", state);
        page.locator(stateLocator).waitFor();
        page.locator(stateLocator).click();
    }

    public void selectCity(String city) {
        String cityLocator = String.format("//div[@id=\"city\"]//div[contains(text(), \"%s\")]", city);
        page.locator(cityLocator).waitFor();
        page.locator(cityLocator).click();
    }

    public void choosePicture(String filePath) {
        this.choosePicture.setInputFiles(Paths.get(filePath));
    }
}

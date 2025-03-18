package org.example.playwright;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.demoqa.pages.HomePage;

import java.nio.file.Paths;

public class FormPage {

    private final Page page;
    private final Locator firstName;
    private final Locator lastName;
    private final Locator email;
    private final Locator mobile;
    private final Locator subjectInput;
    private final Locator subjectOption;
    private final Locator currentAddress;
    private final Locator choosePicture;
    private final Locator selectState;
    private final Locator selectCity;
    private final Locator firstState;
    private final Locator firstCity;
    private final Locator submitButton;


    public FormPage(Page page) {
        this.page = page;
        this.firstName = page.locator("#firstName");
        this.lastName = page.locator("#lastName");
        this.email = page.locator("#userEmail");
        this.mobile = page.locator("#userNumber");
        this.subjectInput = page.locator("#subjectsInput");
        this.subjectOption = page.locator("#react-select-2-option-0");
        this.currentAddress = page.locator("#currentAddress");
        this.choosePicture = page.locator("#uploadPicture");
        this.selectState = page.locator("#state");
        this.selectCity = page.locator("#city");
        this.firstState = page.locator("#react-select-3-option-0");
        this.firstCity = page.locator("#react-select-4-option-0");
        this.submitButton = page.locator("#submit");
    }

    public void fillForm(String firstName, String lastName, String email, String gender, String mobile, String subject, String hobby, String currentAddress, String file) {
        this.firstName.fill(firstName);
        this.lastName.fill(lastName);
        this.email.fill(email);
        selectGender(gender);
        this.mobile.fill(mobile);

        this.subjectInput.fill(subject);
        this.subjectOption.waitFor();
        this.subjectOption.click();

        selectHobby(hobby);
        this.currentAddress.fill(currentAddress);

        choosePicture(file);

        this.selectState.click();
        this.firstState.waitFor();
        this.firstState.click();

        this.selectCity.click();
        this.firstCity.waitFor();
        this.firstCity.click();
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

    public void choosePicture(String filePath) {
        this.choosePicture.setInputFiles(Paths.get(filePath));
    }
}

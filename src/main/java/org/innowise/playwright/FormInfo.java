package org.innowise.playwright;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FormInfo {

    private final Page page;
    private final Locator fullName;
    private final Locator email;
    private final Locator gender;
    private final Locator mobile;
    private final Locator dateOfBirth;
    private final Locator subject;
    private final Locator hobby;
    private final Locator picture;
    private final Locator address;
    private final Locator stateAndCity;


    public FormInfo(Page page) {
        this.page = page;
        this.fullName = page.locator("//td[text()='Student Name']/following-sibling::td");
        this.email = page.locator("//td[text()='Student Email']/following-sibling::td");
        this.gender = page.locator("//td[text()='Gender']/following-sibling::td");
        this.mobile = page.locator("//td[text()='Mobile']/following-sibling::td");
        this.dateOfBirth = page.locator("//td[text()='Date of Birth']/following-sibling::td");
        this.subject = page.locator("//td[text()='Subjects']/following-sibling::td");
        this.hobby = page.locator("//td[text()='Hobbies']/following-sibling::td");
        this.picture = page.locator("//td[text()='Picture']/following-sibling::td");
        this.address = page.locator("//td[text()='Address']/following-sibling::td");
        this.stateAndCity = page.locator("//td[text()='State and City']/following-sibling::td");
    }

    public boolean verifyFormData(String expectedName, String expectedEmail, String expectedGender, String expectedPhone,
                                  String expectedDateOfBirth, String expectedSubject, String expectedHobby,
                                  String expectedAddress, String expectedStateAndCity, String expectedPicture) {
        return fullName.textContent().trim().equals(expectedName)
                && email.textContent().trim().equals(expectedEmail)
                && gender.textContent().trim().equals(expectedGender)
                && mobile.textContent().trim().equals(expectedPhone)
                && dateOfBirth.textContent().trim().equals(expectedDateOfBirth)
                && subject.textContent().trim().equals(expectedSubject)
                && hobby.textContent().trim().equals(expectedHobby)
                && address.textContent().trim().equals(expectedAddress)
                && stateAndCity.textContent().trim().equals(expectedStateAndCity)
                && picture.textContent().trim().equals(expectedPicture);
    }


}

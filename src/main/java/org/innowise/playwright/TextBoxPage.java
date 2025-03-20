package org.innowise.playwright;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class TextBoxPage {

    private final Page page;
    private final Locator fullName;
    private final Locator email;
    private final Locator currentAddress;
    private final Locator permanentAddress;
    private final Locator submitButton;
    private final Locator outputSection;

    public TextBoxPage(Page page) {
        this.page = page;
        this.fullName = page.locator("#userName");
        this.email = page.locator("#userEmail");
        this.currentAddress = page.locator("#currentAddress");
        this.permanentAddress = page.locator("#permanentAddress");
        this.submitButton = page.locator("#submit");
        this.outputSection = page.locator("#output");
    }

    public void fillForm(String fullName, String email, String currentAddress, String permanentAddress) {
        this.fullName.fill(fullName);
        this.email.fill(email);
        this.currentAddress.fill(currentAddress);
        this.permanentAddress.fill(permanentAddress);
    }

    public void submitForm(){
        submitButton.click();
    }

    public boolean isOutputVisible() {
        return outputSection.isVisible();
    }

    public String getOutputText() {
        return outputSection.textContent();
    }


}

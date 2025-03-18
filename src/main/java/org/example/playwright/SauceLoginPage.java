package org.example.playwright;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SauceLoginPage {
    private final Page page;

    private final Locator username;
    private final Locator password;
    private final Locator loginButton;

    public SauceLoginPage(Page page) {
        this.page = page;
        this.username = page.locator("#user-name");
        this.password = page.locator("#password");
        this.loginButton = page.locator("#login-button");
    }

    public void fillForm(String username, String password){
        this.username.fill(username);
        this.password.fill(password);
    }

    public void logIn(){
        this.loginButton.click();
    }
}

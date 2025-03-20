package org.innowise.browserinitialization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxStrategy implements BrowserStrategy {
    @Override
    public WebDriver getDriver() {
        return new FirefoxDriver();
    }
}

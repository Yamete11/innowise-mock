package org.innowise.browserinitialization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeStrategy implements BrowserStrategy {
    @Override
    public WebDriver getDriver() {
        return new ChromeDriver();
    }
}

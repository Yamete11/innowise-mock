package org.example.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxStrategy implements BrowserStrategy {
    @Override
    public WebDriver getDriver() {
        return new FirefoxDriver();
    }
}

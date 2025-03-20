package org.innowise.browserinitialization;

import org.openqa.selenium.WebDriver;

public class BrowserContext {
    private BrowserStrategy strategy;

    public BrowserContext(BrowserStrategy strategy) {
        this.strategy = strategy;
    }

    public WebDriver getDriver() {
        return strategy.getDriver();
    }
}
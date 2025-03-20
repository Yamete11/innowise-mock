package org.innowise.browserinitialization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeStrategy implements BrowserStrategy {
    @Override
    public WebDriver getDriver() {
        return new EdgeDriver();
    }
}

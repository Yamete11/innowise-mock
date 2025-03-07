package org.example.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeStrategy implements BrowserStrategy {
    @Override
    public WebDriver getDriver() {
        return new EdgeDriver();
    }
}

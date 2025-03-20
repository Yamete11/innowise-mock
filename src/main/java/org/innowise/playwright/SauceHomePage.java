package org.innowise.playwright;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;
import java.util.stream.Collectors;

public class SauceHomePage {
    private final Page page;

    private final Locator selector;
    private final Locator itemPrices;

    public SauceHomePage(Page page) {
        this.page = page;
        this.selector = page.locator(".product_sort_container");
        this.itemPrices = page.locator(".inventory_item_price");
    }

    public void selectSortingOption(String value) {
        selector.click();
        selector.selectOption(value);
    }

    public List<Double> getAllPrices() {
        return itemPrices.allInnerTexts().stream()
                .map(price -> price.replaceAll("[^0-9.]", ""))
                .map(Double::valueOf)
                .collect(Collectors.toList());
    }
}

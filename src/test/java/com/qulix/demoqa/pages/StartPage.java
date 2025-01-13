package com.qulix.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage extends BasePage {

    private final By bookStoreCardText = By.xpath("//div/div/h5[contains(text(), 'Book Store Application')]");

    public StartPage(WebDriver webDriver) {
        super(webDriver);
    }

    private WebElement getBookStoreCard() {
        return findPageElement(bookStoreCardText);
    }

}

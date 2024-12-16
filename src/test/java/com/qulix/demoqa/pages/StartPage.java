package com.qulix.demoqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage extends BasePage {

    private final By BOOK_STORE_CARD_TEXT = By.xpath("//div/div/h5[contains(text(), 'Book Store Application')]");

    public StartPage(WebDriver webDriver) {
        super(webDriver);
    }

    private WebElement getBookStoreCard() {
        return findPageElement(BOOK_STORE_CARD_TEXT);
    }

    @Step ("Click on 'Book Store Application' card")
    public WebElement findPageElement(By locator) {
        WebElement webElement = webDriver.findElement(locator);

        if (!webElement.isDisplayed()) {
            scrollToElement(webElement);
        }

        return webElement;
    }

    @Step ("Checking if 'Forms' card is present on the Start page")
    public boolean checkIfFormsCardIsPresent() {
        return isElementDisplayed(getBookStoreCard());
    }

}

package com.qulix.demoqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver webDriver;

    BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected WebElement findPageElement(By locator) {
        return webDriver.findElement(locator);
    }

    @Step
    protected boolean isElementDisplayed(WebElement webElement) {
        if (webElement.isDisplayed()) {
            System.out.println("Element is displayed");
            return true;
        } else {
            throw new NoSuchElementException("Element is not displayed");
        }
    }

    @Step
    protected void verifyElementIsDisplayed(WebElement webElement) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(webElement.isDisplayed(), webElement.getText()+" card is displayed");
        softAssert.assertAll();
    }

     public List<WebElement> findPageElements(By locator) {
        return webDriver.findElements(locator);
    }

    public void waitElementToBeClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable((webElement)));
    }

    public void scrollToElement(WebElement webElement) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement).build().perform();
    }

}

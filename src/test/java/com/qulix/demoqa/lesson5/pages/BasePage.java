package com.qulix.demoqa.lesson5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver webDriver;

    BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected WebElement findPageElement(By locator) {
        WebElement webElement = webDriver.findElement(locator);

        if (!webElement.isDisplayed()) {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].scrollIntoView();", webElement);
        }

        return webElement;
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

package com.qulix.demoqa.lesson3.test;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public abstract class BaseTest {

    static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Step("Открытие страницы {linkUrl}")
    public void openWebsite(String linkURL) {
        webDriver.get(linkURL);
        log.info("Website is opened");
    }

    public WebElement findPageElement(By locator) {
        WebElement webElement = webDriver.findElement(locator);

        if (!webElement.isDisplayed()) {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].scrollIntoView();", webElement);
        }

        return webElement;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        webDriver.quit();
    }
}

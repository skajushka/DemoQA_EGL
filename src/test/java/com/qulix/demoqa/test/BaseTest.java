package com.qulix.demoqa.test;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

//TODO Класс висит в воздухе, хотя по идее может быть использован уже с первых занятий
//TODO Корректнее внутри BaseTest класса оставить реализацию только методов прямо влияющих на ход выполнения теста
//TODO Вот такие common вещи типа openWebSite стоит реализовывать, например, в Steps классе, или какой-нить BrowserActions
public abstract class BaseTest {

    protected WebDriver webDriver;

    @Step
    public void openWebsite(String linkURL) {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        webDriver.manage().window().maximize();
        webDriver.get(linkURL);
    }

    @Step
    public WebElement findPageElement(By locator) {
        WebElement webElement = webDriver.findElement(locator);

        if (!webElement.isDisplayed()) {
            Actions actions = new Actions(webDriver);
            actions.moveToElement(webElement).build().perform();
        }

        return webElement;
    }

    @Step
    public void waitElementToBeClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable((webElement)));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        webDriver.quit();
    }
}

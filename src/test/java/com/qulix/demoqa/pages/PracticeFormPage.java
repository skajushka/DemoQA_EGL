package com.qulix.demoqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class PracticeFormPage extends BasePage {

    private final By PRACTICE_FORM_TITLE = By.xpath("//h1[contains(text(), 'Practice Form')]");
    private final By REGISTRATION_FORM_TITLE = By.xpath("//h5[contains(text(), 'Student Registration Form')]");
    private final By FIRST_NAME_FIELD = By.id("firstName");
    private final By LAST_NAME_FIELD = By.id("lastName");
    private final By EMAIL_FIELD = By.cssSelector("#userEmail");


    PracticeFormPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openWebsite(String linkURL) {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        webDriver.manage().window().maximize();
        webDriver.get(linkURL);
    }

    public WebElement findPageElement(By locator) {
        WebElement webElement = webDriver.findElement(locator);

        if (!webElement.isDisplayed()) {
            Actions actions = new Actions(webDriver);
            actions.moveToElement(webElement).build().perform();
        }

        return webElement;
    }

    @Step
    public void verifyElementsOnPage() {
        Assert.assertTrue(findPageElement(PRACTICE_FORM_TITLE).isDisplayed());
        Assert.assertTrue(findPageElement(REGISTRATION_FORM_TITLE).isDisplayed());
        Assert.assertTrue(findPageElement(FIRST_NAME_FIELD).isDisplayed());
        Assert.assertTrue(findPageElement(LAST_NAME_FIELD).isDisplayed());
    }
}

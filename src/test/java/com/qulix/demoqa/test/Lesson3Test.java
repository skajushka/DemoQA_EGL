package com.qulix.demoqa.test;

import com.qulix.demoqa.utils.Environment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Lesson3Test extends BaseTest {

    WebDriver webDriver;

    // TODO Пока можно не загоняться на config file и переменные.
    //  Но хотя бы вынести в отдельный класс типа Configuration или Environment стоит
    // DONE, перенесла в класс Environment
    //Locators
    private final By practiceFormTitle = By.xpath("//h1[contains(text(), 'Practice Form')]");
    private final By registrationFormTitle = By.xpath("//h5[contains(text(), 'Student Registration Form')]");
    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");

    @Test
    public void openWebsite() throws MalformedURLException {
        //open web page
        openWebsite(new Environment().getPracticeFormUrl());

        //verify elements
        verifyElementsOnPage();
    }

    @Step ("Открытие страницы {linkUrl}")
    public void openWebsite(String linkUrl) {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(linkUrl);
        log.info("Website is opened.");
    }

    @Step ("Верификация отображения элементов на странице")
    public void verifyElementsOnPage() {
        Assert.assertTrue(findPageElement(practiceFormTitle).isDisplayed());
        Assert.assertTrue(findPageElement(registrationFormTitle).isDisplayed());
        Assert.assertTrue(findPageElement(firstNameField).isDisplayed());
        Assert.assertTrue(findPageElement(lastNameField).isDisplayed());
        log.info("Page elements are verified");
    }

}
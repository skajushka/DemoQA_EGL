package com.qulix.demoqa.lesson5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticeFormPage extends BasePage {

    private final By practiceFormTitle = By.xpath("//h1[contains(text(), 'Practice Form')]");
    private final By registrationFormTitle = By.xpath("//h5[contains(text(), 'Student Registration Form')]");
    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");
    private final By emailField = By.cssSelector("#userEmail");

    PracticeFormPage(WebDriver webDriver) {
        super(webDriver);
    }
}

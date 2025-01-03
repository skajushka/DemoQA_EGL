package com.qulix.demoqa.test;

import com.qulix.demoqa.utils.Environment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

// TODO: Лекция 2 у нас про testNG и формально мы еще не знаем кто и что такое Selenium.
//   Потому для этого урока логичнее сделать пример, в котором нет Selenium
//   Можно, например, написать свой класс com.qulix.demoqa.Calculator
//       .plus(x,y)
//       .multiply(x,y)
//       .divide(x,y)
//       .minus(x,y)
// DONE: сделала класс калькулятора, начала реализацию теста для него (Lesson2Test)

//
// TODO:  И далее на примерах показать и dataDriven подход и группы
//  (например, negativeValues, decimalValues, negativeTests, positiveTests)
//  и через разные варианты testng.xml показать как можно управлять ходом выполнения через XML
//
// TODO: По-хорошему тут показать максимально работу разных аннотаций
// DONE: сделано для аннотаций @data-provider, @parameters
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

    // TODO: Тут и везде, @Step обязательно с текстом: @Step("Открытие страницы {linkUrl}")
    // DONE: добавила текст
    // TODO: linkUrl, а не linkURL. Тоже везде, где встречается
    // DONE: поменяла linkURL на linkUrl
    @Step ("Открытие страницы {linkUrl}")
    public void openWebsite(String linkUrl) {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
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
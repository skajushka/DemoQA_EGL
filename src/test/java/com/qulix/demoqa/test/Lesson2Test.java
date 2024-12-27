package com.qulix.demoqa.test;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

// TODO: Лекция 2 у нас про testNG и формально мы еще не знаем кто и что такое Selenium.
//   Потому для этого урока логичнее сделать пример, в котором нет Selenium
//   Можно, например, написать свой класс Calculator
//       .plus(x,y)
//       .multiply(x,y)
//       .divide(x,y)
//       .minus(x,y)
//
// TODO:  И далее на примерах показать и dataDriven подход и группы
//  (например, negativeValues, decimalValues, negativeTests, positiveTests)
//  и через разные варианты testng.xml показать как можно управлять ходом выполнения через XML
//
// TODO: По-хорошему тут показать максимально работу разных аннотаций
public class Lesson2Test {
    WebDriver webDriver;

    // TODO Пока можно не загоняться на config file и переменные.
    //  Но хотя бы вынести в отдельный класс типа Configuration или Environment стоит
    private final String PRACTICE_FORM_URL = "https://demoqa.com/automation-practice-form";
    //Locators
    private final By PRACTICE_FORM_TITLE = By.xpath("//h1[contains(text(), 'Practice Form')]");
    private final By REGISTRATION_FORM_TITLE = By.xpath("//h5[contains(text(), 'Student Registration Form')]");
    private final By FIRST_NAME_FIELD = By.id("firstName");
    private final By LAST_NAME_FIELD = By.id("lastName");

    @Test
    public void openWebsite() throws MalformedURLException {
        //open web page
        openWebsite(PRACTICE_FORM_URL);

        //verify elements
        verifyElementsOnPage();

        //close browser
        webDriver.quit();
    }

    // TODO: Тут и везде, @Step обязательно с текстом: @Step("Открытие страницы {linkUrl}")
    // TODO: linkUrl, а не linkURL. Тоже везде, где встречается
    @Step
    public void openWebsite(String linkURL) {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        webDriver.manage().window().maximize();
        webDriver.get(linkURL);
        System.out.println("Website is opened.");
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
    public void verifyElementsOnPage() {
        Assert.assertTrue(findPageElement(PRACTICE_FORM_TITLE).isDisplayed());
        Assert.assertTrue(findPageElement(REGISTRATION_FORM_TITLE).isDisplayed());
        Assert.assertTrue(findPageElement(FIRST_NAME_FIELD).isDisplayed());
        Assert.assertTrue(findPageElement(LAST_NAME_FIELD).isDisplayed());
        System.out.println("Page elements are verified");
    }

}

package com.qulix.demoqa.test;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
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

//TODO Класс висит в воздухе, хотя по идее может быть использован уже с первых занятий
//TODO Корректнее внутри BaseTest класса оставить реализацию только методов прямо влияющих на ход выполнения теста
//DONE Добавила наследование от этого класса для всех тестовых
// перенесла сюда методы, которые нужны для всех тестов
//TODO Вот такие common вещи типа openWebSite стоит реализовывать, например, в Steps классе, или какой-нить BrowserActions
//ANSWER мне показалось логичным поместить его в этом классе, потому что он переиспользуется в каждом тесте
// не поняла, что ты имеешь в виду под Steps классом

public abstract class BaseTest {

    static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        webDriver.manage().window().maximize();
    }

    @Step("Открытие страницы {linkUrl}")
    public void openWebsite(String linkURL) {
        webDriver.get(linkURL);
        // TODO А вот этого стоит отучать сходу. Есть @Log4j/@Log4j2 из lombok
        //  Весь вывод в консоль только через лог, никаких System.out.println
        // ANSWER: а вот так, через slf4j, норм?
        log.info("Website is opened");
    }

    public WebElement findPageElement(By locator) {
        WebElement webElement = webDriver.findElement(locator);

        if (!webElement.isDisplayed()) {
            Actions actions = new Actions(webDriver);
            actions.moveToElement(webElement).build().perform();
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

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        webDriver.quit();
    }
}

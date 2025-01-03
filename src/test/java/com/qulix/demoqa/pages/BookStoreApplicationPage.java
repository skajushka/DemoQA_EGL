package com.qulix.demoqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class BookStoreApplicationPage extends BasePage {

    // TODO Не каждый final обязывает именовать переменные UPPER_CASE
    //   По-хорошему UPPER_CASE только public static final, т.е. публичные static константы
    //   Локальные final non static поля вообще не нуждаются в отдельном синтаксисе ни по какому из соглашений
    //   Локальные final static поля могут иметь UPPER_CASE, если это оправдано. Но для локаторов, я считаю, это избыточно
    private final By BOOK_STORE_CARD_UP = By.xpath("//h5[contains(text(), 'Book Store Application')]/parent::div/preceding-sibling::div/preceding-sibling::div");
    private final By SEARCH_BOX = By.id("searchBox");
    private final By SEARCH_BOX_BUTTON = By.id("basic-addon2");
    private final By BOOK_STORE_CARD = By.xpath("//div[@class='card-body']/h5[contains(text(), 'Book Store Application')]");
    private final By BOOK_TITLE = By.xpath("//div[@class='rt-td']//a[contains(text(), 'Git')]");

    BookStoreApplicationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public void openWebsite(String linkURL) {
        // TODO Ну инициализации тут точно быть не должно, максимум просто переход по ссылке
        //   Но тогда ссылка хранится внутри класса, а не приходит как внешний параметр
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        webDriver.manage().window().maximize();
        webDriver.get(linkURL);
    }

    public WebElement findPageElement(By locator) {
        return webDriver.findElement(locator);
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

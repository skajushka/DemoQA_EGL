package com.qulix.demoqa.test;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Lesson3Test {

    WebDriver webDriver;

    private final String URL = "https://demoqa.com/";
    private final String SEARCH_REQUEST = "git";
    //Locators
    private final By BOOK_STORE_CARD_UP = By.xpath("//h5[contains(text(), 'Book Store Application')]/parent::div/preceding-sibling::div/preceding-sibling::div");
    private final By SEARCH_BOX = By.id("searchBox");
    private final By SEARCH_BOX_BUTTON = By.id("basic-addon2");
    private final By BOOK_STORE_CARD = By.xpath("//div[@class='card-body']/h5[contains(text(), 'Book Store Application')]");
    private final By BOOK_TITLE = By.xpath("//div[@class='rt-td']//a[contains(text(), 'Git')]");

    @Test
    public void findGitBooksTest() {
        //open site
        openWebsite(URL);

        //go to the Book Store
        WebElement bookStoreCard = findPageElement(BOOK_STORE_CARD);
        scrollToElement(bookStoreCard);
        WebElement bookStoreCardUp = findPageElement(BOOK_STORE_CARD_UP);
        bookStoreCardUp.click();

        //type in search request
        WebElement searchBox = findPageElement(SEARCH_BOX);
        waitElementToBeClickable(searchBox);
        searchBox.sendKeys(SEARCH_REQUEST);

        // click "Search" button
        WebElement searchBoxButton = findPageElement(SEARCH_BOX_BUTTON);
        searchBoxButton.click();

        //collect and print book titles
        List<WebElement> bookTitleElements =findPageElements(BOOK_TITLE);
        List <String> bookTitles = new ArrayList<>();;

        for (WebElement element : bookTitleElements) {
            bookTitles.add(element.getText());
        }

        System.out.println("Book titles for search request " + SEARCH_REQUEST + " are: " + bookTitles);

        //close browser
        webDriver.quit();
    }

    @Step
    public void openWebsite(String linkURL) {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        webDriver.manage().window().maximize();
        webDriver.get(linkURL);
        System.out.println("Website is opened");
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

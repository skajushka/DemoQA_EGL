package com.qulix.demoqa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.qulix.demoqa.utils.Environment;

import java.util.ArrayList;
import java.util.List;

public class Lesson4Test extends BaseTest{

    private final String searchRequest = "git";
    //Locators
    private final By searchBox = By.id("searchBox");
    private final By searchBoxButton = By.id("basic-addon2");
    private final By bookStoreCard = By.xpath("//div[@class='card-body']/h5[contains(text(), 'Book Store Application')]");
    private final By bookTitle = By.xpath("//div[@class='rt-td']//a[contains(text(), 'Git')]");

    @Test
    public void findGitBooksTest() {
        //open site
        //TODO Это SetUp
        // ANSWER: не поняла. У нас этот метод открывает разные страницы в начале текстов.
        // имеется в виду, что надо переименовать ли поменять реализацию?
        openWebsite(new Environment().getBookStorePage());

        //go to the Book Store
        //TODO Какой-то сложноватый блок для старта, там прямо надо скролить?
        //DONE убрала

        //type in search request
        //TODO
        // 1. Я бы не стал в этом уроке объявлять и использовать локаторы как поля класса, особенно в формате UPPER_CASE
        //DONE убрала
        // TODO 2. Что мы экономим, реализуя findPageElement(s) вместо прямого использования webDriver.findElement(s)?
        // ANSWER: в нашей имплементации скролл к элементу добавлен, если его сходу нет на странице
        WebElement searchBox = findPageElement(this.searchBox);
        // TODO: У нас wait-ы в следующем уроке,
        //  по заданию нам тут только построить локаторы и найти элементы, зачем сюда тащить заполнение
        //DONE перенесла это в четвертый урок, где уже есть ожидания
        waitElementToBeClickable(searchBox);
        searchBox.sendKeys(searchRequest);

        // click "Search" button
        WebElement searchBoxButton = findPageElement(this.searchBoxButton);
        searchBoxButton.click();

        //collect and print book titles
        List<WebElement> bookTitleElements =findPageElements(bookTitle);
        List <String> bookTitles = new ArrayList<>();

        for (WebElement element : bookTitleElements) {
            bookTitles.add(element.getText());
        }

        log.info("Book titles for search request are found");

        //close browser
        // TODO: Это tearDown
        // DONE: убрала
    }

}

package com.qulix.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookStoreApplicationPage extends BasePage {

    private final By bookStoreCardUp = By.xpath("//h5[contains(text(), 'Book Store Application')]/parent::div/preceding-sibling::div/preceding-sibling::div");
    private final By searchBox = By.id("searchBox");
    private final By searchBoxButton = By.id("basic-addon2");
    private final By bookStoreCard = By.xpath("//div[@class='card-body']/h5[contains(text(), 'Book Store Application')]");
    private final By bookTitle = By.xpath("//div[@class='rt-td']//a[contains(text(), 'Git')]");

    BookStoreApplicationPage(WebDriver webDriver) {
        super(webDriver);
    }
}

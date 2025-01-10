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
    private final By bookTitle = By.xpath("//div[@class='rt-td']//a[contains(text(), 'Git')]");

    @Test
    public void findGitBooksTest() {
        //open site
        openWebsite(new Environment().getBookStorePageUrl());

        //locate search box
        WebElement searchBox = findPageElement(this.searchBox);
        waitElementToBeClickable(searchBox);

        //type in search request
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
    }

}

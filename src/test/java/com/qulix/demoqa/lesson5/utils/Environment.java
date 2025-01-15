package com.qulix.demoqa.lesson5.utils;

public class Environment {

    private final String practiceFormUrl = "https://demoqa.com/automation-practice-form";
    private final String startPageUrl = "https://demoqa.com/";
    private final String bookStorePageUrl = "https://demoqa.com/books";

    public Environment() {
    }

    public String getPracticeFormUrl() {
        return practiceFormUrl;
    }

    public String getStartPageUrl() {
        return startPageUrl;
    }

    public String getBookStorePageUrl() {
        return bookStorePageUrl;
    }
}

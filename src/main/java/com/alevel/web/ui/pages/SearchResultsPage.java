package com.alevel.web.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'gsc-webResult')]//div[contains(@class, 'gsc-webResult')]")
    private List<WebElement> searchResults;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Getting search resultsssssssssss")
    public List<WebElement> getSearchResults() {
        return searchResults;
    }

}

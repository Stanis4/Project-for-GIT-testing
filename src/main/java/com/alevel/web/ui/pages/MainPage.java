package com.alevel.web.ui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(MainPage.class);
    //By searchInputLocator = By.xpath("//input[@name='q']");

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

    public MainPage inputSearchText(String text) {
        LOGGER.info("Text entered to search input '" + text + "'");
        searchInput.sendKeys(text);
        return this;
    }

    public SearchResultsPage startSearch() {
        searchInput.sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }

}

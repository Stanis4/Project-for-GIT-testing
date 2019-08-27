package com.alevel;

import com.alevel.dataprovider.GeneralDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class SearchTests extends TestBase {

    @Test(dataProviderClass = GeneralDataProvider.class, dataProvider = "provide")
    public void checkSearchResults(String searchText) {
        WebElement searchInput = driver.findElement(By.xpath("//input[@name='q']"));
        searchInput.sendKeys(searchText);
        searchInput.sendKeys(Keys.ENTER);

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[contains(@class, 'gsc-webResult')]//div[contains(@class, 'gsc-webResult')]"));
        for (WebElement result : searchResults) {
            Assert.assertTrue(helper.containsIgnoreCase(result.getText(), searchText));
        }
    }
}

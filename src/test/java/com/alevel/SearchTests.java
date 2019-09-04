package com.alevel;

import com.alevel.dataprovider.GeneralDataProvider;
import com.alevel.web.ui.pages.MainPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class SearchTests extends TestBase {

    @Test(dataProviderClass = GeneralDataProvider.class, dataProvider = "provide")
    public void checkSearchResultsPO(String searchText) {
        List<WebElement> searchResults = new MainPage(driver)
                        .inputSearchText(searchText)
                        .startSearch()
                        .getSearchResults();

        for (WebElement result : searchResults) {
            Assert.assertTrue(helper.containsIgnoreCase(result.getText(), searchText + "123"));
        }
    }
}

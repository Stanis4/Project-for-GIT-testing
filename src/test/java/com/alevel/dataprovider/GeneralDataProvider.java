package com.alevel.dataprovider;

public class GeneralDataProvider {

    @org.testng.annotations.DataProvider
    public Object[][] provide(){
        return new Object[][]{
                {"java"},
                {"python"}
        };
    }
}

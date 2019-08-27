package com.alevel;

import com.alevel.helper.VerificationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver;
    protected VerificationHelper helper;

    //перед всеми тестовыми методами
    @BeforeTest
    public void setUp() {
        String path = System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);

        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        helper = new VerificationHelper();
    }

    //Выполняется перед каждым методом помеченным аннотацией @Test
    @BeforeMethod
    public void openPage(){
        driver.get("https://dou.ua/");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

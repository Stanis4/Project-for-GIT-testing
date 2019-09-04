package com.alevel.listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    private static WebDriver webDriver;

    /**
     * 1. Создаём свой класс-слушатель который implements org.testng.ITestListener
     * 2. В методе onTestFailure Вызываем метод который создаёт скриншоты
     * 3. Добавляем Listener в TestBase при помощи аннотации @Listeners:
     *  @Listeners({AllureListener.class})
     */

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (webDriver != null) {
            takeScreenshot(webDriver);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    @Attachment(type = "image/png")
    public byte[] takeScreenshot(WebDriver driver) {
        byte[] result = null;
        if (driver != null) result = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        return result;
    }

    public static void setDriver(WebDriver driver){
        webDriver = driver;
    }

}

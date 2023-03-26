package com.pages.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.constants.FrameworkConstants.WAIT_TIME;

public class ScreenActions {

    protected AppiumDriver<MobileElement> driver;

    // Constructor
    public ScreenActions(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    protected String getText(By locator) {
        return getMobileElement(locator).getText();
    }

    protected void clickElement(By locator) {
        getMobileElement(locator).click();
    }

    protected void enterText(By locator, String value) {
        getMobileElement(locator).sendKeys(value);
    }

    protected void waitUntilElementIsVisible(By locator, long iTimeout) {
        new WebDriverWait(driver, iTimeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitUntilElementIsClickable(By locator, long iTimeout) {
        new WebDriverWait(driver, iTimeout).until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitUntil(long iTimeout) {
        try {
            Thread.sleep(iTimeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected boolean isElementVisible(By locator, long iTimeInSeconds) {
        try {
            waitUntilElementIsVisible(locator, iTimeInSeconds);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected boolean isElementVisible(By locator) {
        return isElementVisible(locator, WAIT_TIME);
    }

    private MobileElement getMobileElement(By locator) {
        return this.driver.findElement(locator);
    }
}

package com.pages;

import com.pages.screen.ScreenActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class PasswordPage extends ScreenActions {

    private static final By PASSWORD_FIELD = By.xpath("//android.widget.EditText[@resource-id='PASSWORD']");
    private static final By NEXT_BTN = By.xpath("//android.widget.Button[@resource-id='forward-button']");

    public PasswordPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public PasswordPage setPassword(String password) {
        waitUntilElementIsVisible(PASSWORD_FIELD, 20);
        enterText(PASSWORD_FIELD, password);
        return this;
    }

    public HomePage continueToHomePage() {
        waitUntilElementIsClickable(NEXT_BTN, 20);
        clickElement(NEXT_BTN);
        return new HomePage(driver);
    }
}

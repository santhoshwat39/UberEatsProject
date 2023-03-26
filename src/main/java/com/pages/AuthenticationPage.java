package com.pages;

import com.pages.screen.ScreenActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class AuthenticationPage extends ScreenActions {

    private static final By PASSWORD_BTN = By.xpath("//android.widget.Button[@resource-id='alt-PASSWORD']");

    public AuthenticationPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public PasswordPage clickToEnterPassword() {
        waitUntilElementIsVisible(PASSWORD_BTN, 30);
        clickElement(PASSWORD_BTN);
        return new PasswordPage(driver);
    }
}

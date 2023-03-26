package com.pages;

import com.pages.screen.ScreenActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class WelcomePage extends ScreenActions {

    private static final By CONTINUE_BTN = By.id("com.ubercab.eats:id/continue_button");

    public WelcomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public SignInPage continueToSigninPage() {
        waitUntilElementIsClickable(CONTINUE_BTN, 40);
        waitUntil(15000);
        clickElement(CONTINUE_BTN);
        return new SignInPage(driver);
    }
}

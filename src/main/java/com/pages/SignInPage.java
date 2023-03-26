package com.pages;

import com.pages.screen.ScreenActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;


public class SignInPage extends ScreenActions {

    private static final By CANCEL_BTN = By.id("com.google.android.gms:id/cancel");
    private static final By MOBILE_NUMBER_FIELD = By.xpath("//android.widget.EditText[contains(@resource-id,'PHONE_NUMBER')]");
    private static final By CONTINUE_BTN = By.xpath("//android.widget.Button[@resource-id='forward-button']");

    public SignInPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public SignInPage setPhoneNumber(String phoneNumber) {
        boolean status = isElementVisible(CANCEL_BTN, 30);
        if (status){
            clickElement(CANCEL_BTN);
        }
        waitUntilElementIsVisible(MOBILE_NUMBER_FIELD, 50);
        enterText(MOBILE_NUMBER_FIELD, phoneNumber);
        return this;
    }

    public AuthenticationPage continueToAuthenticationPage() {
        clickElement(CONTINUE_BTN);
       // waitUntil(10000);// wait is used to enter the OTP
        return new AuthenticationPage(driver);
    }
}
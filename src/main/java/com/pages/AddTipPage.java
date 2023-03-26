package com.pages;

import com.pages.screen.ScreenActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class AddTipPage extends ScreenActions {

    private static final By CHECK_OUT_PAGE = By.id("com.ubercab.eats:id/ub__checkout_courier_recognition_header_title");

    public AddTipPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean isAddTipPageDisplayed() {
        return isElementVisible(CHECK_OUT_PAGE);
    }
}

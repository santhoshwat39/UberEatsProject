package com.pages;

import com.pages.screen.ScreenActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class RestaurantPage extends ScreenActions {
    private static final By SEARCH_BTN = By.xpath("//android.widget.ImageView[@content-desc=\"Search this store\"]");
    private static final By SEARCH_MENU_FIELD = By.xpath("//*[@text='Search menu']");
    private static final By ITEM_LABEL = By.xpath("//android.widget.TextView[@text='Dasani Water [0.0 Cals]']");

    public RestaurantPage(AppiumDriver<MobileElement> driver) {

        super(driver);
    }

    public RestaurantPage clickOnSearchField(){
        waitUntilElementIsClickable(SEARCH_BTN, 40);
        clickElement(SEARCH_BTN);
        return this;
    }

    public RestaurantPage enterProductOnSearchMenuField(String drinkName){
        waitUntilElementIsClickable(SEARCH_MENU_FIELD, 40);
        enterText(SEARCH_MENU_FIELD, drinkName);
        return this;
    }

    public CartPage clickOnProduct(){
        waitUntilElementIsVisible(ITEM_LABEL, 20);
        clickElement(ITEM_LABEL);
        return new CartPage(driver);
    }
}
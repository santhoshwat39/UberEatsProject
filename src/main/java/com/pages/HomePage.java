package com.pages;

import com.pages.screen.ScreenActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public final class HomePage extends ScreenActions {

    private static final By RESTAURANT_SEARCH_FIELD = MobileBy.id("com.ubercab.eats:id/ub__search_bar_text");
    private static final By RESTAURANT_BTN = By.xpath("//android.widget.TextView[@resource-id='com.ubercab.eats:id/ub__store_slim_row_title']");
    private static final By SEARCH_QUERY_FIELD = By.xpath("//android.widget.EditText[@resource-id='com.ubercab.eats:id/ub__search_query']");

    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public HomePage clickOnSearchIcon() {
        waitUntilElementIsClickable(RESTAURANT_SEARCH_FIELD, 50);
        clickElement(RESTAURANT_SEARCH_FIELD);
        return this;
    }

    public HomePage enterRestaurantName(String restaurantName) {
        waitUntilElementIsVisible(SEARCH_QUERY_FIELD, 20);
        enterText(SEARCH_QUERY_FIELD, restaurantName);
        return this;
    }

    public RestaurantPage clickOnRestaurant() {
        waitUntilElementIsClickable(RESTAURANT_BTN, 20);
        clickElement(RESTAURANT_BTN);
        return new RestaurantPage(driver);
    }
}

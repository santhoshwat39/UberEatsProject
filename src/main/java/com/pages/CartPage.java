package com.pages;

import com.pages.screen.ScreenActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class CartPage extends ScreenActions {

    private static final By ADD_TO_CART_BTN = By.xpath("//android.widget.Button[@resource-id='com.ubercab.eats:id/ub__storefront_menu_item_cart_button']");
    private static final By BACK_TO_RESTAURANT_PAGE = By.xpath("//android.widget.FrameLayout[@resource-id='com.ubercab.eats:id/ub__search_results_container']");
    private static final By VIEW_CART_BTN = By.xpath("//android.widget.TextView[@resource-id='com.ubercab.eats:id/ub__cart_pill_text']");

    public CartPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public CartPage clickToAddCart() {
        waitUntilElementIsVisible(ADD_TO_CART_BTN, 20);
        clickElement(ADD_TO_CART_BTN);
        return this;
    }

    public CartPage clickOnRestaurantPage() {
        waitUntilElementIsVisible(BACK_TO_RESTAURANT_PAGE, 20);
        clickElement(BACK_TO_RESTAURANT_PAGE);
        return this;
    }

    public CheckoutPage clickOnViewCart() {
        waitUntilElementIsVisible(VIEW_CART_BTN, 20);
        clickElement(VIEW_CART_BTN);
        return new CheckoutPage(driver);
    }
}

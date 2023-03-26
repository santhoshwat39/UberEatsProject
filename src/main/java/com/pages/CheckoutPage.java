package com.pages;

import com.pages.screen.ScreenActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class CheckoutPage extends ScreenActions {

    private static final By GOTO_CHECKOUT_BTN = By.xpath("//android.widget.Button[@resource-id='com.ubercab.eats:id/ub__eats_checkout_cart_go_to_checkout_button']");
    private static final By NO_THANKS_BTN = By.xpath("//android.widget.Button[@resource-id='com.ubercab.eats:id/ub__upsell_complement_button']");
    private static final By NEXT_BTN = By.xpath("//android.widget.Button[@text='Next']");
    private static final By SUBTOTAL_VALUE = By.id("com.ubercab.eats:id/ub__eats_checkout_order_subtotal_value");
    private static final By CHECKOUT_PAGE = By.xpath("//android.widget.FrameLayout[@content-desc='Checkout']");

    public CheckoutPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public CheckoutPage clickOnCheckout() {
        waitUntilElementIsVisible(GOTO_CHECKOUT_BTN, 20);
        clickElement(GOTO_CHECKOUT_BTN);
        return this;
    }

    public CheckoutPage clickOnNoThanks() {
        waitUntilElementIsVisible(NO_THANKS_BTN, 20);
        clickElement(NO_THANKS_BTN);
        return this;
    }

    public AddTipPage clickOnNext() {
        waitUntilElementIsClickable(NEXT_BTN, 20);
        clickElement(NEXT_BTN);
        return new AddTipPage(driver);
    }

    public String getCartTotalValue() {
        waitUntilElementIsVisible(SUBTOTAL_VALUE, 20);
        return getText(SUBTOTAL_VALUE);
    }

    public boolean isItemAddedToCart(String itemName) {
        return isElementVisible(By.xpath("//android.widget.TextView[contains(@text,'" + itemName + "')]"), 10);
    }

    public boolean isRestaurantNameDisplayed(String restaurantName) {
        // McDonald's (Knight & 57th)
        return isElementVisible(MobileBy.AccessibilityId(restaurantName), 10);
    }

    public boolean isCheckoutPageDisplayed() {
        return isElementVisible(CHECKOUT_PAGE);
    }
}

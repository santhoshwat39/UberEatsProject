package com.uiTests;

import com.pages.HomePage;
import com.pages.WelcomePage;
import com.setUp.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.constants.FrameworkConstants.PASSWORD;
import static com.constants.FrameworkConstants.PHONE_NUMBER;
import static com.driver.factory.DriverManager.getDriver;

public class UberEatsTests extends BaseTest {

    private static final String RESTAURANT_NAME = "McDonald's (Knight & 57th)";
    private static final String ITEM_NAME = "Dasani Water";

    @Test
    public void selectRestaurantAndCheckOut() {

       // SignIn to UberEats (// code can be commented as login is not needed, if NoReset=True)
       homePage =  new WelcomePage(getDriver())
               .continueToSigninPage()
               .setPhoneNumber(PHONE_NUMBER)
               .continueToAuthenticationPage()
               .clickToEnterPassword()
               .setPassword(PASSWORD)
               .continueToHomePage();

       // Select restaurant
       restaurantPage = new HomePage(getDriver()).clickOnSearchIcon()
               .enterRestaurantName(RESTAURANT_NAME)
               .clickOnRestaurant();

       // Item selection
        cartPage = restaurantPage.clickOnSearchField()
                .enterProductOnSearchMenuField(ITEM_NAME)
                .clickOnProduct();

        // Add to cart
        checkoutPage = cartPage.clickToAddCart()
                .clickOnRestaurantPage()
                .clickOnViewCart();

        // Validate cart page details
        Assert.assertTrue(checkoutPage.isRestaurantNameDisplayed(RESTAURANT_NAME));
        Assert.assertTrue(checkoutPage.isItemAddedToCart(ITEM_NAME));

        // Get total cart value
        String cartTotalValue = checkoutPage.getCartTotalValue();
        System.out.println(cartTotalValue);

        // Final checkout for payment
        checkoutPage.clickOnCheckout()
                .clickOnNoThanks();

        // Validate checkout page title
        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());

        // Navigate to Add tip page
        addTipPage = checkoutPage.clickOnNext();

        // Validate Add tip page title
        Assert.assertTrue(addTipPage.isAddTipPageDisplayed());
    }
}



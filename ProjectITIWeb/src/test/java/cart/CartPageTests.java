package cart;

import com.opencsv.exceptions.CsvValidationException;
import datadriven.ReadDataDrivenClass;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.SelectionHomePage;
import pages.StoreHomePageLogin;
import pages.ThirdSelectedMonitorPage;
import storebase.StoreBaseTests;

import java.io.IOException;

public class CartPageTests extends StoreBaseTests {
    SoftAssert soft =new SoftAssert();

    @Test //(dataProvider = "testData")
//    public void testCartCheckOutScenario( String name, String country, String creditcard, String month, String year) throws InterruptedException, CsvValidationException, IOException {
    public void testCartCheckOutScenario() throws InterruptedException, CsvValidationException, IOException {
        storeHomePageLogin.sendLoginData("salmaNN","hi");
        var firstSelection =StoreHomePageLogin.startSelection();
        firstSelection.clickPhones();
        firstSelection.clickSelectedPhone();

        var firstSelectedPhonePage= SelectionHomePage.clickSelectedPhone();
        firstSelectedPhonePage.addToCartItemOne();
        firstSelectedPhonePage.clickOk();
        firstSelectedPhonePage.backToHomePage();

        var secondSelectedLapPage=SelectionHomePage.clickLaptop();
        secondSelectedLapPage.addToCartItemTwo();
        secondSelectedLapPage.clickOk2();
        secondSelectedLapPage.selectAnotherItem();

        var thirdSelectedMonitorPage =SelectionHomePage.clickMonitor();
        thirdSelectedMonitorPage.AddToCartItem3();
        thirdSelectedMonitorPage.clickOk3();

        var cartPage =ThirdSelectedMonitorPage.goToCartPage();
        soft.assertTrue(cartPage.checkProducts(),"Product title is not displayed");
        soft.assertTrue(cartPage.checkTotal(), "Total didn't appear");
        soft.assertEquals(cartPage.getCartUrl(), "https://www.demoblaze.com/cart.html", "URL is not matching");

        cartPage.deleteMonitor();
        cartPage.sendPlaceOrderData("Zain","USA","XOXOXO","June","2025");
        soft.assertTrue(cartPage.purchaseIsOk(),"Ok and order details didn't appear");
        cartPage.purchaseOkReturnHome();
        soft.assertEquals(CartPage.getHomeURL(), "https://www.demoblaze.com/index.html", "you didn't return Home");

    }

//    @DataProvider
//    public Object [][] testData() throws IOException, InvalidFormatException { //function that returns a multidimentional array. Object bec any class inherits from an object
//        ReadDataDrivenClass read =new ReadDataDrivenClass();
//        return read.readData();
//    }

}

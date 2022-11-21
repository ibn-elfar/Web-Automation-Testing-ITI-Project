package selection;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SelectionHomePage;
import pages.StoreHomePageLogin;
import storebase.StoreBaseTests;

public class SecondSelectionHomeTests extends StoreBaseTests {

    SoftAssert soft= new SoftAssert();

    @Test
    public void testSecondSelection() throws InterruptedException {
        storeHomePageLogin.sendLoginData("salmaNN","hi");

        var firstSelection =StoreHomePageLogin.startSelection();
        firstSelection.clickPhones();
        firstSelection.clickSelectedPhone();

        var firstSelectedPhonePage= SelectionHomePage.clickSelectedPhone();
        firstSelectedPhonePage.addToCartItemOne();
        firstSelectedPhonePage.clickOk();

        soft.assertTrue(firstSelectedPhonePage.getIphonePic(), "Pic doesn't appear");
        soft.assertEquals(firstSelectedPhonePage.getPrice(), "$790", "price didn't appear");


        firstSelectedPhonePage.backToHomePage();
        //assertion that we returned to homepage
        soft.assertTrue(SelectionHomePage.checkCat(), "Categories are not found");
        soft.assertEquals(storeHomePageLogin.CheckLoggedInURL(),"https://www.demoblaze.com/index.html", "URL doesn't match");


        //assertions that we are in homepage again
        soft.assertTrue(SelectionHomePage.checkCat(), "Laptops category didn't appear");
        soft.assertEquals(SelectionHomePage.checkLoggedInURL2(),"https://www.demoblaze.com/index.html#");
        SelectionHomePage.clickLaptop();


    }





}

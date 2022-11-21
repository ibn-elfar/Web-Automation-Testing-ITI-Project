package selection;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SelectionHomePage;
import pages.StoreHomePageLogin;
import storebase.StoreBaseTests;

public class SecondSelectionTests extends StoreBaseTests {

SoftAssert soft=new SoftAssert();

@Test
public void testSuccessfulAddToCart2() throws InterruptedException {
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

    soft.assertEquals(storeHomePageLogin.checkLoggedIn(),"Log out", "you failed logging in");
    soft.assertTrue(storeHomePageLogin.checkLoggedIn2(),"Log out button didn't appear");
    soft.assertEquals(storeHomePageLogin.CheckLoggedInURL(),"https://www.demoblaze.com/index.html", "URL doesn't match");


    var secondSelectedLapPage=SelectionHomePage.clickLaptop();
    secondSelectedLapPage.addToCartItemTwo();
    secondSelectedLapPage.clickOk2();
    soft.assertTrue(secondSelectedLapPage.getMacProPic(), "Pic didn't appear");
    soft.assertEquals(secondSelectedLapPage.getPriceLap(),"$1100", "Laptop price didn't appear");

    secondSelectedLapPage.selectAnotherItem();
    soft.assertTrue(SelectionHomePage.checkCat(),"Categories didn't appear in SelectionHomePage");
    soft.assertEquals(SelectionHomePage.checkLoggedInURL2(),"https://www.demoblaze.com/index.html#");


}

}

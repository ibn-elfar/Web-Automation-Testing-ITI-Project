package selection;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SelectionHomePage;
import pages.StoreHomePageLogin;
import pages.ThirdSelectedMonitorPage;
import storebase.StoreBaseTests;


public class ThirdSelectionTests extends StoreBaseTests {
    SoftAssert soft=new SoftAssert();

    @Test
    public void testSuccessfulAddToCart3() throws InterruptedException {
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

        soft.assertTrue(SelectionHomePage.checkCat(),"Categories didn't appear in SelectionHomePage");
        soft.assertEquals(SelectionHomePage.checkLoggedInURL2(),"https://www.demoblaze.com/index.html#");
        var thirdSelectedMonitorPage =SelectionHomePage.clickMonitor();
        thirdSelectedMonitorPage.AddToCartItem3();
        thirdSelectedMonitorPage.clickOk3();
        soft.assertTrue(ThirdSelectedMonitorPage.getMonitorPic(), "Monitor pic didn't appear");
        soft.assertEquals(ThirdSelectedMonitorPage.getMonitorPrice(), "Price didn't appear");

    }
}

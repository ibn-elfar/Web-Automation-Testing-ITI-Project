package completescenario;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SelectionHomePage;
import pages.StoreHomePageLogin;
import pages.ThirdSelectedMonitorPage;
import storebase.StoreBaseTests;

public class CompleteScenarioTests extends StoreBaseTests {
    SoftAssert soft=new SoftAssert();

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        storeHomePageLogin.sendLoginData("salmaNN","hi");
   }
   @Test (dependsOnMethods = "testSuccessfulLogin")
   public void TestFirstSelectionAfterLogin() throws InterruptedException {
       var firstSelection =StoreHomePageLogin.startSelection();
       firstSelection.clickPhones();
       firstSelection.clickSelectedPhone();
   }
    @Test (dependsOnMethods = "TestFirstSelectionAfterLogin")
    public void TestSuccessfulAddToCart () throws InterruptedException {
        var firstSelectedPhonePage= SelectionHomePage.clickSelectedPhone();
        firstSelectedPhonePage.addToCartItemOne();
        firstSelectedPhonePage.clickOk();
        firstSelectedPhonePage.backToHomePage();
    }
    @Test(dependsOnMethods = "TestSuccessfulAddToCart")
    public void testSuccessfulAddToCart2() throws InterruptedException {
        var secondSelectedLapPage=SelectionHomePage.clickLaptop();
        secondSelectedLapPage.addToCartItemTwo();
        secondSelectedLapPage.clickOk2();
        secondSelectedLapPage.selectAnotherItem();
    }
    @Test (dependsOnMethods ="testSuccessfulAddToCart2" )
    public void testSuccessfulAddToCart3() throws InterruptedException {
        var thirdSelectedMonitorPage =SelectionHomePage.clickMonitor();
        thirdSelectedMonitorPage.AddToCartItem3();
        thirdSelectedMonitorPage.clickOk3();
    }
    @Test(dependsOnMethods = "testSuccessfulAddToCart3")
    public void testCartCheckOutScenario() throws InterruptedException {
        var cartPage =ThirdSelectedMonitorPage.goToCartPage();
        cartPage.deleteMonitor();
        cartPage.sendPlaceOrderData("Salma", "Egypt","XOXOXOXO", "June","2023");
        cartPage.purchaseOkReturnHome();
    }

}

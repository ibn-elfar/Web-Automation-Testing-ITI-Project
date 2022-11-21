package login;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import storebase.StoreBaseTests;


public class LoginTests extends StoreBaseTests {
    SoftAssert soft =new SoftAssert();
    //here we can inherit from StoreHomePageLogin that we got from StoreBasesTests
    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        storeHomePageLogin.sendLoginData("salmaNN","hi");
        storeHomePageLogin.startSelection();

       // storeHomePageLogin.clickPhones();

        soft.assertEquals(storeHomePageLogin.checkLoggedIn(),"Log out", "you failed logging in");
        soft.assertTrue(storeHomePageLogin.checkLoggedIn2(),"Log out button didn't appear");
        soft.assertEquals(storeHomePageLogin.CheckLoggedInURL(),"https://www.demoblaze.com/index.html", "URL doesn't match");
    }


}

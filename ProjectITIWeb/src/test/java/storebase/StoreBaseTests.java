package storebase;

import io.github.bonigarcia.wdm.WebDriverManager;
import login.LoginTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

public class StoreBaseTests {
    private WebDriver driver;
    protected StoreHomePageLogin storeHomePageLogin; // providing a handle to our framework
    protected SignUpPage signUpPage;

//we will create a method to setup the page
    @BeforeClass
    public void setDriver () {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get("https://www.demoblaze.com/index.html");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        //now the application is launched we will provide a handle to our StoreHomePageLogin
        storeHomePageLogin =new StoreHomePageLogin(driver);
        signUpPage = new SignUpPage(driver);
//loginTests =new LoginTests(driver);
    };

    @AfterClass
    public void closeDriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

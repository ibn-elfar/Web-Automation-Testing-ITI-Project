package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


//here we want to have fields that represent the elements on this homepage
//Also the methods to interact with these elements
public class StoreHomePageLogin {
    //adding locators at our global scope
    private static WebDriver driver;
    private By login = By.cssSelector("#login2"); // defined an object of class By to focus on login then will create a method to interact with it
    private By usernameField = By.id("loginusername");
    private By passwordField =By.id("loginpassword");
    private By loginButton =By.cssSelector("[onclick=\"logIn()\"]");
    private By loggedInToLogOut =By.id("logout2");


    public StoreHomePageLogin(WebDriver driver) {
        this.driver = driver;
    }


    //we can make an assertion that specific things appear on this page
    //the below method takes a string username to send

    public void sendLoginData(String username, String password) throws InterruptedException {
        driver.findElement(login).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        //Thread.sleep(1500);
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
    public static SelectionHomePage startSelection(){
        return new SelectionHomePage(driver);
    }




    //methods created to help in assertions and make sure we are logged in and selected a phone
    public String checkLoggedIn() throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(loggedInToLogOut).getText();
    }
    public boolean checkLoggedIn2() {
        return driver.findElement(loggedInToLogOut).isDisplayed();
    }
    public String CheckLoggedInURL (){
        driver.getCurrentUrl();
        return driver.getCurrentUrl();
    }




}

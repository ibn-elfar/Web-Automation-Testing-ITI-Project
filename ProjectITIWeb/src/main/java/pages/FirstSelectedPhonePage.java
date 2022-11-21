package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class FirstSelectedPhonePage {
    private WebDriver driver;
    private By addToCartItem1 =By.linkText("Add to cart");
    private By iphonePic =By.xpath("//img[@src=\"imgs/iphone_6.jpg\"]");
    private By price =By.cssSelector("[class=\"price-container\"]");
    private By backToHomePage= By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a");


    public FirstSelectedPhonePage(WebDriver driver) {
        this.driver =driver;
    }
    public void addToCartItemOne() throws InterruptedException {
        // Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.findElement(addToCartItem1).click();
    }
    public void clickOk() throws InterruptedException {
        Thread.sleep(2000);
        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50)); --> only for Document object model
        //make sure can not click anything unless alert is clicked
        driver.switchTo().alert().accept();
    }
public SelectionHomePage backToHomePage(){
        driver.findElement(backToHomePage).click();
        return new SelectionHomePage(driver);
}
    //methods for assertion purpose
    public boolean getIphonePic (){
        driver.findElement(iphonePic).isDisplayed();
        return true;
    }
    public String getPrice(){
        return driver.findElement(price).getText();
    }


}

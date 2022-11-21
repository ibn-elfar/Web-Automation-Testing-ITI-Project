package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SecondSelectedLapPage {
    static WebDriver driver;
    private By addToCartItem2 =By.linkText("Add to cart");
    private  By macBookProPic =By.cssSelector("[src=\"imgs/macbook_air.jpg\"]");
    private By priceLap =By.cssSelector("[class=\"price-container\"]");
    private static By checkCategories = By.xpath("//a[@id=\"cat\"]");
    private By backToHomePage= By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a");

    public SecondSelectedLapPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCartItemTwo() throws InterruptedException {
        // Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.findElement(addToCartItem2).click();
    }
    public void clickOk2() throws InterruptedException {
        Thread.sleep(2000);
        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50)); --> only for Document object model
        //make sure can not click anything unless alert is clicked
        driver.switchTo().alert().accept();
    }
    //assertion methods
    public boolean getMacProPic () throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(macBookProPic).isDisplayed();
        return true;
    }
    public String getPriceLap(){
        return driver.findElement(priceLap).getText();
    }

    public SelectionHomePage selectAnotherItem(){
        driver.findElement(backToHomePage).click();
        return new SelectionHomePage(driver);
    }


}

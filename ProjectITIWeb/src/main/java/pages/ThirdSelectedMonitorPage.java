package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class ThirdSelectedMonitorPage {
    static WebDriver driver;
    private By addToCartItem3 =By.linkText("Add to cart");
    private static By monitorPic =By.cssSelector("[src=\"imgs/apple_cinema.jpg\"]");
    private static By priceMonitor =By.cssSelector("[class=\"price-container\"]");
    private static By cart = By.xpath("//*[@id=\"cartur\"]");
    public ThirdSelectedMonitorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void AddToCartItem3 (){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.findElement(addToCartItem3).click();
    }
    public void clickOk3() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
    }

public static CartPage goToCartPage(){
        driver.findElement(cart).click();
        return new CartPage(driver);

}
    // methods for assertion
    public static boolean getMonitorPic(){
        driver.findElement(monitorPic).isDisplayed();
        return true;
    }
    public static String getMonitorPrice(){
        return driver.findElement(priceMonitor).getText();
    }

}

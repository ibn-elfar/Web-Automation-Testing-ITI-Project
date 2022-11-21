package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectionHomePage {
    //public static String checkLoggedInURL2;
    static WebDriver driver;
    private static By checkCat = By.xpath("//a[@id=\"cat\"]");
    private static By laptop =By.xpath("//a[@onclick=\"byCat('notebook')\"]");
    private static By chosenLaptop =By.partialLinkText("MacBook Pro");
    private static By monitors =By.xpath("//a[@onclick=\"byCat('monitor')\"]");
    private static By chosenMonitor= By.partialLinkText("Apple monitor 24");

    private By choosePhones =By.xpath("//*[@id=\"itemc\"]");
    private static By selectedPhone=By.xpath("//*[@id=\"tbodyid\"]/div[5]/div/div/h4/a");


    public SelectionHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPhones() throws InterruptedException {
        //  new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(choosePhones));
        Thread.sleep(7000);
        driver.findElement(choosePhones).click();
        Thread.sleep(5000);
        driver.findElement(selectedPhone).click();
    }

    public static FirstSelectedPhonePage clickSelectedPhone() throws InterruptedException {
        Thread.sleep(1500);
        return new FirstSelectedPhonePage(driver);
    }

    public static SecondSelectedLapPage clickLaptop() throws InterruptedException {
        driver.findElement(laptop).click();
        Thread.sleep(3000);
        driver.findElement(chosenLaptop).click();
        return new SecondSelectedLapPage(driver);
    }

public static ThirdSelectedMonitorPage clickMonitor() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(monitors).click();
        Thread.sleep(3000);
        driver.findElement(chosenMonitor).click();
        return new ThirdSelectedMonitorPage(driver);
}
 //method for assertion purpose(we returned to homepage after selection1)
    public static boolean checkCat() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(checkCat).isDisplayed();
        return true;
    }
    public static String checkLoggedInURL2(){
        return driver.getCurrentUrl();
    }

}

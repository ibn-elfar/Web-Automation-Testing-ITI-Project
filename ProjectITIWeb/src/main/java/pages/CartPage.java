package pages;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.Duration;

public class CartPage {
    static WebDriver driver;

    private By total= By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/h2");
    private By products =By.xpath("//*[@id=\"page-wrapper\"]/div/div[1]/h2");
    private By deleteMonitor =By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[4]/a");
    private By placeOrder =By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    private By enterName =By.xpath("//*[@id=\"name\"]");
    private By enterCountry = By.xpath("//*[@id=\"country\"]");
    private  By enterCreditCard =By.xpath("//*[@id=\"card\"]");
    private By enterMonth =By.xpath("//*[@id=\"month\"]");
    private By enterYear =By.xpath("//*[@id=\"year\"]");
    private By purchase =By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    private By purchaseOk =By.xpath("/html/body/div[10]/div[7]/div/button");
    private By close= By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[1]"); //assertion
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void deleteMonitor() throws InterruptedException {
        driver.findElement(deleteMonitor).click();
        Thread.sleep(2000);
    }
    public void sendPlaceOrderData (String name, String country, String creditCard, String month, String year) throws InterruptedException {
        driver.findElement(placeOrder).click();
        Thread.sleep(5000);
        driver.findElement(enterName).sendKeys(name);
        driver.findElement(enterCountry).sendKeys(country);
        driver.findElement(enterCreditCard).sendKeys(creditCard);
        driver.findElement(enterMonth).sendKeys(month);
        driver.findElement(enterYear).sendKeys(year);
        driver.findElement(purchase).click();
    }

    public SelectionHomePage purchaseOkReturnHome() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(purchaseOk).click();
        return new SelectionHomePage(driver);
    }

    public void readData() throws IOException, CsvValidationException, InterruptedException {
        CSVReader reader = new CSVReader(new FileReader("D:\\ITI\\Testing\\Selenium Testing\\ProjectITIWeb\\testData\\DataDriven.csv"));
        String csvCell[];

        while ((csvCell = reader.readNext()) != null) {
            String name = csvCell[0];
            String country = csvCell[1];
            String creditcard = csvCell[2];
            String month = csvCell[3];
            String year = csvCell[4];

            driver.findElement(placeOrder).click();
            Thread.sleep(5000);
            driver.findElement(enterName).sendKeys(name);
            driver.findElement(enterCountry).sendKeys(country);
            driver.findElement(enterCreditCard).sendKeys(creditcard);
            driver.findElement(enterMonth).sendKeys(month);
            driver.findElement(enterYear).sendKeys(year);
            driver.findElement(purchase).click();
            driver.findElement(purchaseOk).click();
        }
    }

    //assertion methods
    public boolean purchaseIsOk(){
        driver.findElement(purchaseOk).isDisplayed();
        driver.findElement(close).isDisplayed();
        return true;
    }
    public boolean checkTotal(){
        driver.findElement(total).isDisplayed();
        return true;
    }
    public boolean checkProducts(){
        driver.findElement(products).isDisplayed();
        return true;
    }
    public String getCartUrl(){
       return driver.getCurrentUrl();
    }
    public static String getHomeURL(){return driver.getCurrentUrl();}
}


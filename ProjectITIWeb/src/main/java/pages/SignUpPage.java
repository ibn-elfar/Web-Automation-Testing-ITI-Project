package pages;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SignUpPage {
    WebDriver driver;
private By signUp = By.xpath("//*[@id=\"signin2\"]");
private By signUpUserName = By.xpath("//*[@id=\"sign-username\"]");
private  By signUpPassword =By.xpath("//*[@id=\"sign-password\"]");
private By signUpButton =By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
private  By signUpCloseButton=By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[1]");
private By backHome =By.xpath("//*[@id=\"nava\"]/img");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public StoreHomePageLogin signUp() throws IOException, CsvValidationException, InterruptedException {
        CSVReader reader = new CSVReader(new FileReader("D:\\ITI\\Testing\\Selenium Testing\\ProjectITIWeb\\testData\\DataDriven.csv"));
        String csvCell[];

        while ((csvCell = reader.readNext()) != null) {
            String signupname = csvCell[0];
            String signuppassword = csvCell[1];

            driver.findElement(signUp).click();
            Thread.sleep(4000);

            driver.findElement(signUpUserName).sendKeys(signupname);
            driver.findElement(signUpPassword).sendKeys(signuppassword);
            driver.findElement(signUpButton).click();
            Thread.sleep(4000);
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
            driver.findElement(backHome).click();
        }
        return new StoreHomePageLogin(driver);


//public StoreHomePageLogin returnToLoginPage(){
//        return new StoreHomePageLogin(driver);
//}

    //assertion method
//    public boolean setSignUpButtonAppears (){
//        driver.findElement(signUpButton).isDisplayed();
//        driver.findElement(signUpCloseButton).isDisplayed();
//        return true;
//    }
}}

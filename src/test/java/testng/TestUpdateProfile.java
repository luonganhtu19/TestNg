package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testng.Method.Account;


public class TestUpdateProfile {
    static WebDriver driver;
    static Account accountSuccess;
    @BeforeTest
    void setupTestUpdateProfile() throws InterruptedException {
        TestLoginWeb.setup();
        driver =TestLoginWeb.driver;
    }

    @Test
    void updatePassword() throws InterruptedException {
        String cssSelector = "#main > div > div.order-wrapper.mt-40.my-account > div.row > div.col-lg-8.col-xl > div.order-block.my-account-wrapper.row > div.col-md-7 > form > div:nth-child(7) > div.col-12.col-input.form-buttons > a";
        String xpath = "/html/body/main/div/div[2]/div[1]/div[3]/div[2]/div[1]/form/div[7]/div[2]/a";
        accountSuccess = new Account("luonganhtu1995@gmail.com","Hoa@2112");

        TestLoginWeb.login(accountSuccess);
        Boolean result = TestLoginWeb.findElementByXpath(xpath);
        if (!result) Assert.assertTrue(false);
        updatePassword(accountSuccess.password,"Hoa@1995");
        accountSuccess.setPassword("Hoa@1995");
        TestLoginWeb.backLogin();
        TestLoginWeb.login(accountSuccess);
        if (!driver.getTitle().contains("Thông tin tài khoản")){
            result = false;
        }
        Assert.assertTrue(result);
    }


    @AfterSuite
    void teardownTestUpdateProfile() throws InterruptedException {
        TestLoginWeb.teardown();
    }
    public static void updatePassword(String passOldValue,String passNewValue) throws InterruptedException {
        WebElement passOld = driver.findElement(By.name("customer_pass_old"));
        passOld.clear();
        passOld.sendKeys(passOldValue);
        WebElement passNew1 = driver.findElement(By.name("customer_pass_new1"));
        passNew1.clear();
        passNew1.sendKeys(passNewValue);
        WebElement passNew2 = driver.findElement(By.id("customer_pass_new2"));
        passNew2.clear();
        passNew2.sendKeys(passNewValue);
        //click button
        WebElement buttonChangePass = driver.findElement(By.id("change_pass"));
        buttonChangePass.click();
        Thread.sleep(10000);
    }

}

package testng;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import testng.Method.Account;
import testng.Util.Utils;

import java.util.List;

import static testng.Util.Utils.setupUrlFile;


public class TestLoginWeb {

    static WebDriver driver;
    static Account accountSuccess;
    static Account accountFail;

    @BeforeTest
    public static void setup() throws InterruptedException {
        try {
            driver = new SafariDriver();
            System.out.println("Opening browser");
            WebDriverManager.safaridriver().setup();
            driver.manage().window().maximize();
            driver.get("https://ivymoda.com/customer/login");
            System.out.println(driver.getTitle() + "---------------");
            String title = driver.getTitle();
            System.out.println("-----------------" + title);
            System.out.println("--------------" + title.contains("IVY moda"));
//            Assert.assertTrue(title.contains("IVY moda"));
        }catch (Exception e){
            driver.close();
            e.printStackTrace();
        }
    }

    @DataProvider(name = "accountProvider")
    Object[][] accountProvider() throws InterruptedException {
        System.out.println("This is login test");
//        customer_account
//        customer_password
//        driver.wait();

        List<Account> accounts = Utils.readWorkBookAccounts(setupUrlFile("account.xlsx"),new Account(),"account");
        int length= accounts.size();
        Object[][] newObjects = new Object[length][1];
        for (int i =0;i<length;i++){
            newObjects[i][0] = accounts.get(i);
        }
        return newObjects;
    }



    @Test(priority = 2)
    private void checkLoginSuccess() throws InterruptedException {
        Boolean result = false;
        login(accountSuccess);
        if (driver.getTitle().contains("Thông tin tài khoản")){
            backLogin();
            result = true;
        }
        Assert.assertTrue(result);
    }

    @Test(priority = 3)
    private void  checkLoginFail() throws InterruptedException {
        accountFail = new Account("tesst1","test2");
        login(accountFail);
        Thread.sleep(1000);
        WebElement errorAlert = driver.findElement(By.cssSelector(".alert.alert-warning"));
        String alert=errorAlert.getText();
        System.out.println(alert+"--------------------------82");
        Assert.assertTrue(alert.contains("Lỗi"));
    }

//    @Test(priority = 4)
//    private void  checkLoginRemember() throws InterruptedException {
//        accountSuccess = new Account("luonganhtu1995@gmail.com","Hoa@2112");
//        WebElement remember =driver.findElement(By.name("customer_remember"));
//        remember.click();
//        fillLogin(accountSuccess);
//        backLogin();
//    }

    @Test(priority = 1,dataProvider = "accountProvider")
    private void checkListAccountLoginSuccess(Account account) throws InterruptedException {
        Boolean result =false;
        login(account);
        if (driver.getTitle().contains("Thông tin tài khoản")){
            backLogin();
            accountSuccess =account;
            result = true;
        }
        accountFail =account;
        Assert.assertTrue(result);
    }


    @AfterSuite
    public static void teardown() throws InterruptedException {
        System.out.println("closing browser");
        driver.quit();
    }

    public static void backLogin() throws InterruptedException {
        WebElement avatarLink =  driver.findElement(By.cssSelector(".item.wallet a.icon i.icon-ic_avatar"));
        System.out.println("---------------69"+avatarLink.toString());
        avatarLink.click();
        Thread.sleep(5000);
        WebElement logout =  driver.findElement(By.cssSelector(".item.wallet .sub-action li a[href='https://ivymoda.com/customer/logout']"));
        logout.click();
        Thread.sleep(2000);
        driver.get("https://ivymoda.com/customer/login");
    }

    public static void login(Account account) throws InterruptedException {
        WebElement usernameField = driver.findElement(By.name("customer_account"));
        usernameField.clear();
        usernameField.sendKeys(account.userName);
        WebElement passwordField = driver.findElement(By.name("customer_password"));
        passwordField.clear();
        passwordField.sendKeys(account.password);
        WebElement loginButton = driver.findElement(By.id("but_login_email"));
        loginButton.click();
        Thread.sleep(10000);
    }

    public static boolean findElementByXpath(String xPath) throws InterruptedException {
        WebElement webElement = driver.findElement(By.xpath(xPath));
//        if (webElement.size()==0) Assert.assertTrue(false);
//        webElement.get(0).click();
        webElement.click();
        Thread.sleep(6000);
        return true;
    }
}

package testng;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testng.Method.Account;

import java.util.List;

public class TestCart {
    static WebDriver driver;
    static Account accountSuccess;
    @BeforeTest
    void setupTestUpdateProfile() throws InterruptedException {
        TestLoginWeb.setup();
        driver =TestLoginWeb.driver;
        accountSuccess = new Account("luonganhtu1995@gmail.com","Hoa@1995");
        TestLoginWeb.login(accountSuccess);
    }

    @Test(priority = 1)
    void checkMyCart() throws InterruptedException {
        //click view cart after login
        WebElement cart = driver.findElement(By.cssSelector("#header > div > div.right-header > div > div.item.item-cart > a > i"));
        cart.click();
        Thread.sleep(2000);
        WebElement checkViewCart = driver.findElement(By.cssSelector("#header > div > div.right-header > div > div.item.item-cart > div > div.bottom-action > div.box-action > a.action-view-cart"));
        checkViewCart.click();
        Thread.sleep(2000);
        System.out.println("-------------------"+driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Giỏ hàng"));
    }

    @Test(priority = 2)
    void checkButtonIncreaseItem() throws InterruptedException {
        Boolean result= false;
        String cssSelectorProduct= "#box_product_total_cart > div.cart__list > table > tbody > tr:nth-child(1) > td:nth-child(3) > div > input[type=number]";
        List<WebElement> items = driver.findElements(By.cssSelector("div.product-detail__quantity--increase"));
        if (items.size()==0) Assert.assertTrue(result);
        WebElement item = items.get(0);
        int qualityItemBeforeAction = checkNumberOfProduct(cssSelectorProduct);
        System.out.println("------47: "+qualityItemBeforeAction);
        item.click();
        Thread.sleep(6000);
        int qualityItemAfterAction = checkNumberOfProduct(cssSelectorProduct);
        System.out.println("------47: "+qualityItemAfterAction);
        Assert.assertEquals(qualityItemBeforeAction+1,qualityItemAfterAction);
    }
    @AfterSuite
    void teardownTestUpdateProfile() throws InterruptedException {
        TestLoginWeb.teardown();
    }
    int checkNumberOfProduct(String cssSelector){
        WebElement numberProduct = driver.findElement(By.cssSelector(cssSelector));
         String numberString = numberProduct.getAttribute("value");
         try {
             return Integer.parseInt(numberString);
         }catch (NumberFormatException e){
             e.printStackTrace();
             return 0;
         }
    }
}

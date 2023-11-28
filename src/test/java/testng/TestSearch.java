package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testng.Method.Account;

import java.util.List;

public class TestSearch {
    static WebDriver driver;
    static Account accountSuccess;
    @BeforeTest
    void setupTestUpdateProfile() throws InterruptedException {
        TestLoginWeb.setup();
        driver =TestLoginWeb.driver;
        accountSuccess = new Account("luonganhtu1995@gmail.com","Hoa@1995");
        TestLoginWeb.login(accountSuccess);
    }
    @Test
    void searchByKeyword() throws InterruptedException {

        WebElement search = driver.findElement(By.id("search-quick"));
        search.sendKeys("Check");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        Boolean result = checkResultSearch("Check");
        Assert.assertTrue(result);
    }
    @AfterSuite
    void teardownTestUpdateProfile() throws InterruptedException {
        TestLoginWeb.teardown();
    }
    Boolean checkResultSearch(String keyword){
        List<WebElement> titles = driver.findElements(By.cssSelector("div.info-product > h3"));
        long count= titles.stream().filter(item->keyword.contains(item.getText())).count();
        if (count == (long) titles.size()) return true;
        return false;
    }
}

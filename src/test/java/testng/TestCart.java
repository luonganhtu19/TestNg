package testng;

import com.beust.ah.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testng.Method.Account;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestCart {
    static WebDriver driver;
    static Account accountSuccess;
    private static final String HOME_IVY = "#header > div > div.site-brand > a > img";
    static List<String> productsInCart;
    static int priceTotalInCart;


    @BeforeTest
    void setupTestUpdateProfile() throws InterruptedException {
        TestLoginWeb.setup();
        driver =TestLoginWeb.driver;
        accountSuccess = new Account("luonganhtu1995@gmail.com","Hoa@1995");
        TestLoginWeb.login(accountSuccess);
        openViewCartMini();
    }

    @Test(priority = 0)
    void checkInformationCartInit(){
        checkInformationOfCart();
    }
    @Test(priority = 1)
    void checkAddItem() throws InterruptedException{
        //check cart add Item
        checkInformationOfCart();
        List<String> itemsBeforeAdd = productsInCart;
        Integer priceTotalBeforeAdd =priceTotalInCart;
        WebElement homeBack = driver.findElement(By.cssSelector(HOME_IVY));
        checkWebElement(homeBack);
        homeBack.click();
        Thread.sleep(3000);

        WebElement product = driver.findElement(By.cssSelector("#tab-women > div.list-products.new-prod-slider.owl-carousel.owl-loaded > div.owl-stage-outer > div > div:nth-child(1) > div > div > div.info-product > h3 > a"));
        checkWebElement(product);
        String nameProductAddCart = product.getText();

        //click bag
        WebElement clickBag =driver.findElement(By.cssSelector("#tab-women > div.list-products.new-prod-slider.owl-carousel.owl-loaded > div.owl-stage-outer > div > div:nth-child(1) > div > div > div.add-to-cart > a > i"));
        checkWebElement(clickBag);
        clickBag.click();



        //add size l
        WebElement sizeL = driver.findElement(By.cssSelector("#tab-women > div.list-products.new-prod-slider.owl-carousel.owl-loaded > div.owl-stage-outer > div > div:nth-child(1) > div > div > div.list-size.open > ul > li:nth-child(3) > button"));
        checkWebElement(sizeL);
        sizeL.click();

        // Xử lý thông báo (ví dụ: in nó ra console)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        try{
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notify__add-to-cart--success")));
        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
        Thread.sleep(1000);

        // check xem item add
        checkInformationOfCart();
        List<String> itemsAfter = productsInCart;
//        int priceTotalAfter = priceTotalInCart;
        // check item add in cart before add
        long countBefore = itemsBeforeAdd.stream().filter(item->item.equals(nameProductAddCart.trim())).count();
        long countAfter = itemsAfter.stream().filter(item->item.equals(nameProductAddCart.toString())).count();
        if (countBefore+1!=countAfter) fail();
        success();
    }

    @Test(priority = 2)
    void checkButtonIncreaseItem() throws InterruptedException {
        checkInformationOfCart();
        List<String> itemsBeforeAdd = productsInCart;
        if (itemsBeforeAdd.size()==0) success();

        WebElement product = driver.findElement(By.cssSelector(ConstantCssSelector.CartMini.ITEM_NAME_CSS));
        checkWebElement(product);
        String nameProductAddCart = product.getText();

        WebElement clickInCrease = driver.findElement(By.cssSelector(ConstantCssSelector.CartMini.ITEM_INCREASE));
        checkWebElement(clickInCrease);
        clickInCrease.click();
        Thread.sleep(2000);


        checkInformationOfCart();
        List<String> itemsAfter = productsInCart;
        long countBefore = itemsBeforeAdd.stream().filter(item->item.equals(nameProductAddCart.trim())).count();
        long countAfter = itemsAfter.stream().filter(item->item.equals(nameProductAddCart.toString())).count();
        if (countBefore+1!=countAfter) fail();
        success();
    }
    @Test(priority = 3)
    void checkButtonDecreaseItem() throws InterruptedException {
        checkInformationOfCart();
        List<String> itemsBeforeAdd = productsInCart;
        if (itemsBeforeAdd.size()==0) success();

        WebElement product = driver.findElement(By.cssSelector(ConstantCssSelector.CartMini.ITEM_NAME_CSS));
        checkWebElement(product);
        String nameProductAddCart = product.getText();

        WebElement clickDeCrease = driver.findElement(By.cssSelector(ConstantCssSelector.CartMini.ITEM_DECREASE));
        checkWebElement(clickDeCrease);
        clickDeCrease.click();
        Thread.sleep(2000);


        checkInformationOfCart();
        List<String> itemsAfter = productsInCart;
        long countBefore = itemsBeforeAdd.stream().filter(item->item.equals(nameProductAddCart.trim())).count();
        long countAfter = itemsAfter.stream().filter(item->item.equals(nameProductAddCart.toString())).count();
        if (countBefore-1!=countAfter) fail();
        success();
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
    void openViewCartMini() throws InterruptedException {
        WebElement cart = driver.findElement(By.cssSelector("#header > div > div.right-header > div > div.item.item-cart > a > i"));
        cart.click();
        Thread.sleep(2000);
    }
    void checkWebElement(WebElement element){
        if (element==null)
        Assert.assertTrue(false);
    }
    void fail(){
        Assert.assertTrue(false);
    }
    void success(){
        Assert.assertTrue(true);
    }
    List<String> getItemsInCart(){
        List<String> results = new ArrayList<>();
        List<WebElement> webListProduct= driver.findElements(By.cssSelector("div.info-product-cart > h3 > a"));
        if (webListProduct.size()==0) return null;
        checkWebElement(webListProduct.get(0));
        webListProduct.stream().forEach(item->results.add(item.getText()));
        return results;
    }
    String getNumberItemInCart(){
        WebElement elementNumberProductInCart= driver.findElement(By.cssSelector("#header > div > div.right-header > div > div.item.item-cart > div > div.top-action > h3 > span"));
        checkWebElement(elementNumberProductInCart);
        return elementNumberProductInCart.getText();
    }
    String getTotalPriceInCart(){
        WebElement elementTotalPrice = driver.findElement(By.cssSelector("#header > div > div.right-header > div > div.item.item-cart > div > div.bottom-action > div.total-price > strong"));
        checkWebElement(elementTotalPrice);
        return elementTotalPrice.getText();
    }
    List<Integer> getLisPriceInCart(){
        List<WebElement> elementPrices = driver.findElements(By.cssSelector(" div.info-product-cart > div.info-price-mini.d-flex > div.price-cart-mini > ins > span"));
        return elementPrices.stream().map(item->{
            String itemValue = item.getText();
            try {
                return Integer.parseInt(convertStringPriceToFormatPrice(itemValue));
            }catch (Exception e){
                e.printStackTrace();
                return 0;
            }
        }).collect(Collectors.toList());
    }
    String convertStringPriceToFormatPrice(String stringPrice){
        if(stringPrice==null)fail();
        stringPrice = stringPrice.trim();
        String priceDouble= stringPrice.substring(0,stringPrice.length()-1);

        return priceDouble.replaceAll("\\.","");
    }
    void checkInformationOfCart(){
        // kiem tra so luong san pham
        String numberItem = getNumberItemInCart();
        List<String> titleItem = getItemsInCart();
        productsInCart=titleItem;
        if (!numberItem.equals(titleItem.size()+"")) fail();
        if (titleItem.size()==0) success();

        // kiem tra so tien trong gio hang
        List<Integer> price = getLisPriceInCart();
        String totalPriceInCart = convertStringPriceToFormatPrice(getTotalPriceInCart());

        try {
            priceTotalInCart=Integer.parseInt(totalPriceInCart);
            if (priceTotalInCart!= price.stream().reduce(0,Integer::sum)) fail();
        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
        success();
    }

    private static class ConstantCssSelector{
        static class CartMini{
           static final String ITEM_NAME_CSS = "#header > div > div.right-header > div > div.item.item-cart > div > div.main-action > div:nth-child(1) > div.info-product-cart > h3 > a";
           static final String ITEM_DECREASE = "#header > div > div.right-header > div > div.item.item-cart > div > div.main-action > div:nth-child(1) > div.info-product-cart > div.info-price-mini.d-flex > div.info-price-quantity.d-flex > div.price-quantity-minus.price-quantity > i";
           static final String ITEM_INCREASE = "#header > div > div.right-header > div > div.item.item-cart > div > div.main-action > div:nth-child(1) > div.info-product-cart > div.info-price-mini.d-flex > div.info-price-quantity.d-flex > div.price-quantity-plus.price-quantity > i";
        }
    }
}

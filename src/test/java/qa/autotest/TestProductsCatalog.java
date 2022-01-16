package qa.autotest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class TestProductsCatalog extends TestBase {

    //Navigate==========================================================================================================private String UrlCatalog = "http://intershop5.skillbox.ru/product-category/catalog/";


    @Test
    public void set(){
        //driver.navigate().to(hp.UrlCatalog); - а это работает..
        hp.open(hp.UrlCatalog); // Почему выдает ошибку ????
        //java.lang.NullPointerException: Cannot invoke "org.openqa.selenium.WebDriver.navigate()" because "this.driver" is null
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        hp.findContactsMainPage();

    }




}

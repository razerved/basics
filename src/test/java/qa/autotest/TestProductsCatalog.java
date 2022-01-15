package qa.autotest;

import org.junit.Test;

public class TestProductsCatalog extends TestBase {

    private String UrlCatalog = "http://intershop5.skillbox.ru/product-category/catalog/";

    @Test
    public void set(){
        driver.navigate().to(UrlCatalog);
    }

}

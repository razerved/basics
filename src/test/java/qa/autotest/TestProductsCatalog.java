package qa.autotest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;


public class TestProductsCatalog extends TestBase {

    //Navigate==========================================================================================================

    /**
     * Проверка основных секций, элементов на странице
     */
    @Test
    public void testCheckCatalogElements(){
        driver.get(hp.UrlCatalog);
        Assert.assertTrue("Категории товаров отсутствуют",
                driver.findElement(hp.productCategoriesLocator).isDisplayed());
        Assert.assertTrue("Фильтр отсутствует",
                driver.findElement(hp.productFilterLocator).isDisplayed());
        hp.findContactsMainPage();

    }

    /**
     * Проверка редиректа в корзину, при покупке
     */
    @Test
    public void testAddingToBasket(){
        driver.get(hp.UrlCatalog);
        driver.findElements(hp.buttonBasketCatalogLocator).get(2).click();
        driver.findElement(hp.buttonDetailedCatalogLocator).click();
        String actMyCart = driver.getCurrentUrl();
        Assert.assertEquals("Редирект на: "
                + hp.UrlBasket + "не прошел", hp.UrlBasket, actMyCart );

    }

    /**
     * Проверка поисковой строки, при вводе Холодильник - результат поиска Холодильник
     * но не выводимого товара
     */
    @Test
    public void testCheckSearchPanel(){
        driver.get(hp.UrlCatalog);
        driver.findElement(hp.searchLocator).sendKeys("холодильник");
        driver.findElement(hp.searchLocator).sendKeys(Keys.ENTER);
        Assert.assertTrue("Выведенный текст отличается от отображаемого",
                driver.findElement(hp.catalogSearchResultLocator)
                        .getText().equals("Результаты Поиска “Холодильник”"));
        //Assert.assertTrue(driver.findElements(hp.searchProductNameLocator).equals("Холодиль"));
    }

}

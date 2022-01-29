package qa.autotest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestBascet extends TestBase {


    /**
     * Проверка применения купона sert500 - скидка 500 руб.
     */
    @Test
    public void testCoupon(){
        driver.get(hp.UrlCatalog);
        driver.findElements(hp.buttonBasketCatalogLocator).get(2).click();
        driver.findElement(hp.buttonDetailedCatalogLocator).click();
        driver.findElement(hp.enterCouponLocator).sendKeys("sert500");
        driver.findElement(hp.buttonCouponLocator).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(hp.textSertLocator));
        String actRes = driver.findElement(hp.textSertLocator).getText();
        Assert.assertEquals("Вызывается купон 'Скидка: sert500' ",
                "СКИДКА: SERT500 -500,00₽ [Удалить]",actRes);
        /*String priceText = driver.findElement(hp.textPriceLocator).getText();
        int price = Integer.parseInt(priceText); // это итоговое число для оплаты
        int priceWithCoupon = (price - 500);
        if (price == priceWithCoupon){
            Assert.assertTrue("Скидка применена корректно", (price==priceWithCoupon));
        }else {
            Assert.assertTrue("Скидка применена не корректно", (price!=priceWithCoupon));
        }*/
        driver.findElement(hp.buttonBasketCheckoutLocator).click();

    }



    /**
     * Может изменить количество
     */
    @Test
    public void testCanChangQuantity(){
        driver.get(hp.UrlCatalog);
        driver.findElements(hp.buttonBasketCatalogLocator).get(2).click();
        driver.findElement(hp.buttonDetailedCatalogLocator).click();
        driver.findElement(hp.changeNumberLocator).sendKeys(Keys.ARROW_RIGHT);
        driver.findElement(hp.changeNumberLocator).sendKeys(Keys.BACK_SPACE);
        driver.findElement(hp.changeNumberLocator).sendKeys("0");
        driver.findElement(hp.changeNumberLocator).sendKeys(Keys.ENTER);
        var x = driver.findElement(hp.emptyBasketTextLocator).getText();
        Assert.assertEquals("Запись Корзина пуста не появилась","Корзина пуста." , x);
    }



    /**
     * Удаление товара из корзины и восстановление
     */
    @Test
    public void deleteAndRecoveryProduct(){
        driver.get(hp.UrlCatalog);
        driver.findElements(hp.buttonBasketCatalogLocator).get(2).click();
        driver.findElement(hp.buttonDetailedCatalogLocator).click();
        String product = driver.findElement(hp.nameProductLocator).getText();
        driver.findElement(hp.removeButtonLocator).click();
        var x = driver.findElement(hp.emptyBasketTextLocator).getText();
        Assert.assertEquals("Запись Корзина пуста не появилась","Корзина пуста." , x);
        driver.findElement(hp.returnProductLocator).click();
        Assert.assertTrue("Название товара отличается",product.equals(product));

    }


    /**
     * Применен не верный купон (проверка валидности информ ошибки)
     */
    @Test
    public void notCorrectCoupon(){
        driver.get(hp.UrlCatalog);
        driver.findElements(hp.buttonBasketCatalogLocator).get(2).click();
        driver.findElement(hp.buttonDetailedCatalogLocator).click();
        driver.findElement(hp.enterCouponLocator).sendKeys("rest500");
        driver.findElement(hp.buttonCouponLocator).click();
        String actRes = driver.findElement(hp.notCorrectCouponTextLocator).getText();
        Assert.assertEquals("Вызывается не правильный купон 'Скидка: rest500' ",
                "Неверный купон.",actRes);
    }


    /**
     * Оформленный товар редирект на страницу оформление заказа
     */
    @Test
    public void orderProcessing(){
        driver.get(hp.UrlCatalog);
        driver.findElements(hp.buttonBasketCatalogLocator).get(2).click();
        driver.findElement(hp.buttonDetailedCatalogLocator).click();
        driver.findElement(hp.buttonBasketCheckoutLocator).click();
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(hp.checkoutHeaderLocator));
        try {
            Thread.sleep(500);
            String ActResult = driver.getCurrentUrl();
            Assert.assertEquals("Редирект на: "
                    + hp.UrlOrderProcessing + "не прошел", hp.UrlOrderProcessing, ActResult);
        }catch (Exception e){}
    }

}

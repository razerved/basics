package qa.autotest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TestMainPage extends TestBase{

    /**
     * Проверка основных секций, элементов на странице
     */
    @Test
    public void testCheckMainElements(){
        driver.get(hp.UrlMain);
        Assert.assertTrue("Logo отсутствует",driver.findElement(hp.logoTitleLocator).isDisplayed());
        Assert.assertTrue("Кнопка 'Войти' отсутствует",driver.findElement(hp.enterLocator).isDisplayed());
        Assert.assertTrue("Секция 'Распродажа' отсутствует",driver
                .findElement(hp.sectionSaleLocator).isDisplayed());
        Assert.assertTrue("Секция 'Новые Товары' отсутствует",driver
                .findElement(hp.sectionNewCollectionLocator).isDisplayed());
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        hp.findContactsMainPage();
        Assert.assertTrue("Секция 'Контакты' отсутствует",driver.findElement(hp.contactsInfoLocator).isDisplayed());
    }

    /**
     * Проверка правильности редиректа Навигационной панели
     */
    @Test
    public void testCheckRedirectPanel(){
        driver.get(hp.UrlMain);
        driver.findElement(hp.navigationMyAccPanelLocator).click();
        String actMyAccount = driver.getCurrentUrl();
        Assert.assertEquals("Переход осуществлен на страницу: "
                + actMyAccount + " ", hp.UrlAuthoriz , actMyAccount);

        driver.get(hp.UrlMain);
        driver.findElement(hp.navigationBasketPanelLocator).click();
        String actMyBasket = driver.getCurrentUrl();
        Assert.assertEquals("Переход осуществлен на страницу: "
                + actMyBasket + " ", hp.UrlBasket , actMyBasket);

        driver.get(hp.UrlBasket);
        driver.findElement(hp.navigationMainPanelLocator).click();
        String actMyMain = driver.getCurrentUrl();
        Assert.assertEquals("Переход осуществлен на страницу: "
                + actMyMain + " ", hp.UrlMain , actMyMain);

    }

    /**
     * Проверка авторизации
     */
    @Test
    public void testAuthorization(){
        hp.authorizationMethod();
    }



    /**
     * Проверка регистрации
     */
    @Test
    public void testRegistration(){
        hp.randomRegistrationMethod();
    }




    @Test
    public void buyingProduct(){
        /**
         * позже
         */

    }
}

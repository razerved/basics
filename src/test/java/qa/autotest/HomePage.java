package qa.autotest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage extends TestBase{

    //Navigate==========================================================================================================
    private String UrlMain = "http://intershop5.skillbox.ru/";
    private String UrlRegister = "http://intershop5.skillbox.ru/register/";
    private String UrlAuthoriz = "http://intershop5.skillbox.ru/my-account/";
    private String UrlBasket = "http://intershop5.skillbox.ru/cart/";

    //Values============================================================================================================
    public String name = "Ivan Ivanov";
    public String mail = "setset1@set.com";
    public String password = "1qaz!QAZ";

    //Locators==========================================================================================================
    //section=======================================================================================================
    public By logoTitleLocator = By.cssSelector("#site-branding a.site-logo");
    public By sectionSaleLocator = By.cssSelector("aside#accesspress_store_product-2");
    public By sectionNewCollectionLocator = By.cssSelector("aside#accesspress_store_product-3");
    public By contactsInfoLocator = By.cssSelector("div.cta-desc_simple");
    //navigation====================================================================================================
    public By navigationMainPanelLocator = By.xpath("//a[text()='Главная']/parent::li[@id]");
    public By navigationCatalogPanelLocator = By.xpath("//a[text()='Каталог']");
    public By navigationMyAccPanelLocator = By.xpath("//a[text()='Мой аккаунт']/parent::li[@id]");
    public By navigationBasketPanelLocator = By.xpath("//a[text()='Корзина']/parent::li[@id]");
    public By navigationOrderPanelLocator = By.xpath("//a[text()='Оформление заказа']/parent::li[@id]");
    //product=======================================================================================================
    public By saleCollectionLocator = By.xpath("//span[@class='onsale'][text()='Скидка!']");
    public By newCollectionLocator = By.xpath("//span[@class='label-new'][text()='Новый!']");

    //logIn=========================================================================================================
    public By enterLocator = By.cssSelector(".login-woocommerce a");
    public By logInNameLocator = By.cssSelector("#username");
    public By logInPassLocator = By.cssSelector("#password");
    public By hiUserNameLocator = By.xpath("//span[@class='user-name']");


    public By enterButtonLocator = By.cssSelector(".woocommerce-form-login__submit");
    public By authorizationLocator = By.cssSelector(".custom-register-button");
    //registration==================================================================================================
    public By registrationUserNameLocator = By.cssSelector("#reg_username");
    public By registrationMailAddressLocator = By.cssSelector("#reg_email");
    public By registrationPasswordLocator = By.cssSelector("#reg_password");
    public By registrationButtonLocator = By.cssSelector("button[name='register']");
    public By registrationPassTextLocator = By.xpath("//div[text()='Регистрация завершена']");
    //personal account==============================================================================================
    public By ordersLocator = By.cssSelector("li.woocommerce-MyAccount-navigation-link--orders a");

    //specificMethod================================================================================================



    @Test
    public void checkElements(){
        driver.navigate().to(UrlMain);

        Assert.assertTrue("Logo отсутствует",driver.findElement(logoTitleLocator).isDisplayed());
        Assert.assertTrue("Кнопка 'Войти' отсутствует",driver.findElement(enterLocator).isDisplayed());
        Assert.assertTrue("Секция 'Распродажа' отсутствует",driver
                .findElement(sectionSaleLocator).isDisplayed());
        Assert.assertTrue("Секция 'Новые Товары' отсутствует",driver
                .findElement(sectionNewCollectionLocator).isDisplayed());
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        th.findContactsMainPage();
        Assert.assertTrue("Секция 'Контакты' отсутствует",driver.findElement(contactsInfoLocator).isDisplayed());
    }

    @Test
    public void checkRedirectPanel(){

        driver.navigate().to(UrlMain);
        driver.findElement(navigationMyAccPanelLocator).click();
        String actMyAccount = driver.getCurrentUrl();
        Assert.assertEquals("Переход осуществлен на страницу: "
                + actMyAccount + " ",UrlAuthoriz , actMyAccount);

        driver.navigate().to(UrlMain);
        driver.findElement(navigationBasketPanelLocator).click();
        String actMyBasket = driver.getCurrentUrl();
        Assert.assertEquals("Переход осуществлен на страницу: "
                + actMyBasket + " ",UrlBasket , actMyBasket);

        driver.navigate().to(UrlBasket);
        driver.findElement(navigationMainPanelLocator).click();
        String actMyMain = driver.getCurrentUrl();
        Assert.assertEquals("Переход осуществлен на страницу: "
                + actMyMain + " ",UrlMain , actMyMain);

    }

    @Test
    public void authorization(){
        driver.navigate().to(UrlAuthoriz);
        driver.findElement(logoTitleLocator).isDisplayed();
        driver.findElement(logInNameLocator).sendKeys(name);
        driver.findElement(logInPassLocator).sendKeys(password);
    }

    @Test
    public void registration(){
        driver.navigate().to(UrlRegister);
        driver.findElement(logoTitleLocator).isDisplayed();
        driver.findElement(registrationUserNameLocator).sendKeys(th.randomText());
        driver.findElement(registrationMailAddressLocator).sendKeys(th.randomGuid());
        driver.findElement(registrationPasswordLocator).sendKeys(password);
        driver.findElement(registrationButtonLocator).click();
        Assert.assertTrue("Слова 'Вы зарегистрированы!' отсутствуют",
                driver.findElement(registrationPassTextLocator).isDisplayed());
    }

    @Test
    public void buyingProduct(){
        /**
         * позже
         */

    }
}

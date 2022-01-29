package qa.autotest.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.autotest.TestBase;

import java.util.List;
import java.util.Random;

public class HelperPage extends TestBase {

    //private HelperPage driver;
    /*public HelperPage(WebDriver driver){
        this.driver = driver;
        //header = new HeaderPanel(driver);
    }*/
    public void openset(String url){
        driver.get(url);
    }

    //Navigate==========================================================================================================
    public String UrlMain = "http://intershop5.skillbox.ru/";
    public String UrlRegister = "http://intershop5.skillbox.ru/register/";
    public String UrlAuthoriz = "http://intershop5.skillbox.ru/my-account/";
    public String UrlBasket = "http://intershop5.skillbox.ru/cart/";
    public String UrlCatalog = "http://intershop5.skillbox.ru/product-category/catalog/";
    public String UrlOrderProcessing = "http://intershop5.skillbox.ru/checkout/";
    public String UrlCheckout = "http://intershop5.skillbox.ru/checkout/";

    //Values============================================================================================================
    public String name = "Ivan Ivanov";
    public String mail = "setset1@set.com";
    public String password = "1qaz!QAZ";
    public String addresCheckout = "Красная Площадь 1";
    public String nameCheckout = "Иван";
    public String lastNameCheckout = "Иванов";
    public String cityCheckout = "Москва";
    public String stateCheckout = "Москва";
    public String indexCheckout = "141140";
    public String phoneCheckout = "88000000000";
    public String mailCheckout = "setset1@set.com";

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
    /*@FindBy(xpath = "//span[@class='onsale'][text()='Скидка!']")
    private List<WebElement>allSaleCollectionLocator;*/
    public By saleCollectionLocator = By.xpath("//span[@class='onsale'][text()='Скидка!']");
    /*@FindBy(xpath = "//span[@class='label-new'][text()='Новый!']")
    private List<WebElement> allNewCollectionLocator;*/
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
        //search========================================================================================================
    public By searchLocator = By.cssSelector(".search-field");
        //Catalog=======================================================================================================
    public By allProductsCatalogLocator = By.cssSelector("div.wc-products");
    public By buttonBasketCatalogLocator = By.cssSelector("a.button.add_to_cart_button");
    public By buttonDetailedCatalogLocator = By.cssSelector("a.added_to_cart.wc-forward");
        //sectionCatalog================================================================================================
    public By productCategoriesLocator = By.cssSelector(".widget.woocommerce.widget_product_categories");
    public By productFilterLocator = By.cssSelector(".widget.woocommerce.widget_price_filter");

    public By catalogSearchResultLocator = By.cssSelector(".woocommerce-breadcrumb.accesspress-breadcrumb span");
    //public By stept = By.xpath("");
    //public By stept = By.xpath("");
    //public By stept = By.xpath("");
    //public By stept = By.cssSelector("");
    //public By stept = By

    public By searchProductNameLocator = By.xpath("//ul//h3[contains(text(), 'Холодиль')]");


        //Basket========================================================================================================
    //public By stept = By.xpath("");
    public By buttonCouponLocator = By.cssSelector("button[name='apply_coupon']");
    public By buttonBasketCheckoutLocator = By.cssSelector("a.button.wc-forward");
    public By enterCouponLocator = By.cssSelector("#coupon_code");
    public By removeButtonLocator = By.cssSelector(".remove");
    public By deleteCouponLocator = By.cssSelector(".woocommerce-remove-coupon");
    public By textSertLocator = By.cssSelector("tr.coupon-sert500");
    public By textPriceLocator = By.xpath("tr[@class='order-total']//span/*[text()[contains(., ',00')]]");
    public By changeNumberLocator = By.cssSelector("input.input-text.qty.text");
    public By emptyBasketTextLocator = By.cssSelector("p.cart-empty.woocommerce-info");
    public By returnProductLocator = By.cssSelector("a.restore-item");
    public By nameProductLocator = By.cssSelector("td.product-name a");
    public By notCorrectCouponTextLocator = By.cssSelector("ul.woocommerce-error li");
        //Ordering======================================================================================================
    public By checkoutHeaderLocator = By.cssSelector("span.current");

        //Checkout======================================================================================================
    public By inputNameLocator = By.cssSelector("input#billing_first_name");
    public By inputSecondNameLocator = By.cssSelector("input#billing_last_name");
    public By countryLocator = By.cssSelector("span#select2-billing_country-container");
    public By inputAddressLocator = By.cssSelector("input#billing_address_1");
    public By inputCityLocator = By.cssSelector("input#billing_city");
    public By inputStateLocator = By.cssSelector("input#billing_state");
    public By inputIndexLocator = By.cssSelector("input#billing_postcode");
    public By inputPhoneLocator = By.cssSelector("input#billing_phone");
    public By inputMailLocator = By.cssSelector("input#billing_email");
    public By radioButtonBankLocator = By.cssSelector("input#payment_method_bacs");
    public By radioButtonCourierLocator = By.cssSelector("input#payment_method_cod");
    public By buttonOrderLocator = By.cssSelector("button#place_order");
    public By inputCommentsLocator = By.xpath("//*[@id='order_comments']");
    public By finalOrderTextLocator = By.cssSelector("p.woocommerce-thankyou-order-received");
    public By lastOrderTextLocator = By.cssSelector("li.woocommerce-order-overview__order strong");
    public By erorrMessageLocator = By.cssSelector("div.woocommerce-NoticeGroup-checkout");


        //PersonalArea==================================================================================================
    public By orderPersonalAreaLocator = By.xpath("//a[text()='Заказы']");
    public By numberOrderPersonalAreaLocator = By.cssSelector("mark.order-number");



    //Methods===========================================================================================================
    public String randomGuid(){
        return randomText() + '@' + randomText() + ".com";
    }

    public String randomFIO(){
        return randomText() + " " + randomText() + " " + randomText();
    }

    public String randomText(){
        Random rnd = new Random();
        char[] pwdChars = {'a','b','c','d','e','f','g','n','i','j','k','l'};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++){
            char n = (char) rnd.nextInt(12);
            sb.append(pwdChars[n]);
        }
        return sb.toString();
    }

    //specificMethod================================================================================================
    public void findContactsMainPage() {
        try{
            Thread.sleep(2000);
            driver.findElement(contactsInfoLocator).isDisplayed();
        }catch (Exception e){
            System.out.println("[Error]: couldn't find locator");
        }
    }

    public void authorizationMethod() {
        driver.get(hp.UrlMain);
        driver.findElement(hp.logoTitleLocator).isDisplayed();
        driver.findElement(hp.enterLocator).click();
        driver.findElement(hp.logInNameLocator).sendKeys(hp.name);
        driver.findElement(hp.logInPassLocator).sendKeys(hp.password);
        driver.findElement(hp.enterButtonLocator).click();
    }

    public void randomRegistrationMethod() {
        driver.get(hp.UrlMain);
        driver.findElement(hp.logoTitleLocator).isDisplayed();
        driver.findElement(hp.enterLocator).click();
        driver.findElement(hp.authorizationLocator).click();
        driver.findElement(hp.registrationUserNameLocator).sendKeys(hp.randomText());
        driver.findElement(hp.registrationMailAddressLocator).sendKeys(hp.randomGuid());
        driver.findElement(hp.registrationPasswordLocator).sendKeys(hp.password);
        driver.findElement(hp.registrationButtonLocator).click();
        Assert.assertTrue("Слова 'Вы зарегистрированы!' отсутствуют",
                driver.findElement(hp.registrationPassTextLocator).isDisplayed());
    }


        /*private void aasrtSaleLabelsOnProductsDiscount(){
        for (var productslabel : allProductslabelsOnSale){
            Assert.assertTrue("Ну е всех товаров", productslabel.getAttribute("class").contains("onsale"));
        }
        }*/
        /*private void addProductWithDiscount(){
            driver.findElement(registrationButtonLocator).click();
        }*/

        /*private String getTitle(){
            return driver.findElement(registrationButtonLocator).getText();
        }*/
        /*private String getSubTitle(){
            return driver.findElement(registrationButtonLocator).getText();
        }*/

}

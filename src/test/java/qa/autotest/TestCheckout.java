package qa.autotest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestCheckout extends TestBase {
    String numOrder;

    @Test
    public void testRedirectCheckoutPage(){
        hp.authorizationMethod();
        driver.get(hp.UrlCatalog);
        driver.findElements(hp.buttonBasketCatalogLocator).get(2).click();
        driver.findElement(hp.buttonDetailedCatalogLocator).click();
        driver.findElement(hp.buttonBasketCheckoutLocator).click();
        String actUrl = driver.getCurrentUrl();
        Assert.assertEquals("Редирект на: "
                + hp.UrlCheckout + "не прошел", hp.UrlCheckout, actUrl );
    }

    @Test
    public void testConfirmCourier(){
        hp.randomRegistrationMethod();
        driver.get(hp.UrlCatalog);
        driver.findElements(hp.buttonBasketCatalogLocator).get(2).click();
        driver.findElement(hp.buttonDetailedCatalogLocator).click();
        driver.findElement(hp.buttonBasketCheckoutLocator).click();
        driver.findElement(hp.inputNameLocator).sendKeys(hp.nameCheckout);
        driver.findElement(hp.inputSecondNameLocator).sendKeys(hp.lastNameCheckout);
        Assert.assertTrue(driver.findElement(hp.countryLocator).getText().equals("Russia"));
        driver.findElement(hp.inputAddressLocator).sendKeys(hp.addresCheckout);
        driver.findElement(hp.inputCityLocator).sendKeys(hp.cityCheckout);
        driver.findElement(hp.inputStateLocator).sendKeys(hp.stateCheckout);
        driver.findElement(hp.inputIndexLocator).sendKeys(hp.indexCheckout);
        driver.findElement(hp.inputPhoneLocator).sendKeys(hp.phoneCheckout);
        driver.findElement(hp.radioButtonCourierLocator).click();
        driver.findElement(hp.buttonOrderLocator).click();
        Assert.assertTrue(driver.findElement(hp.finalOrderTextLocator)
                .getText()
                .equals("Спасибо! Ваш заказ был получен."));
        numOrder = driver.findElement(hp.lastOrderTextLocator).getText();
    }

    @Test
    public void testCheckNotFilledFields(){
        hp.randomRegistrationMethod();
        driver.get(hp.UrlCatalog);
        driver.findElements(hp.buttonBasketCatalogLocator).get(2).click();
        driver.findElement(hp.buttonDetailedCatalogLocator).click();
        driver.findElement(hp.buttonBasketCheckoutLocator).click();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        driver.findElement(hp.buttonOrderLocator).click();
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Assert.assertTrue(driver.findElement(hp.erorrMessageLocator)
                .isDisplayed());
    }

    @Test
    public void testConfirmBank(){
        hp.randomRegistrationMethod();
        driver.get(hp.UrlCatalog);
        driver.findElements(hp.buttonBasketCatalogLocator).get(2).click();
        driver.findElement(hp.buttonDetailedCatalogLocator).click();
        driver.findElement(hp.buttonBasketCheckoutLocator).click();
        driver.findElement(hp.inputNameLocator).sendKeys(hp.nameCheckout);
        driver.findElement(hp.inputSecondNameLocator).sendKeys(hp.lastNameCheckout);
        Assert.assertTrue(driver.findElement(hp.countryLocator).getText().equals("Russia"));
        driver.findElement(hp.inputAddressLocator).sendKeys(hp.addresCheckout);
        driver.findElement(hp.inputCityLocator).sendKeys(hp.cityCheckout);
        driver.findElement(hp.inputStateLocator).sendKeys(hp.stateCheckout);
        driver.findElement(hp.inputIndexLocator).sendKeys(hp.indexCheckout);
        driver.findElement(hp.inputPhoneLocator).sendKeys(hp.phoneCheckout);
        driver.findElement(hp.radioButtonBankLocator).click();
        driver.findElement(hp.buttonOrderLocator).click();
        Assert.assertTrue(driver.findElement(hp.finalOrderTextLocator)
                .getText()
                .equals("Спасибо! Ваш заказ был получен."));
    }

}

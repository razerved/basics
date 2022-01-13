package qa.autotest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static HomePage hp;
    protected static TestHelper th;
    protected static ProductsCatalog pc;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers\\\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 7000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        hp = new HomePage();
        th = new TestHelper();
        pc = new ProductsCatalog();
    }



    @After
    public void tearDown(){
        driver.quit();
    }
}

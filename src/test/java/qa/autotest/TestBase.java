package qa.autotest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.autotest.pages.HelperPage;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected static WebDriver driver;
    protected WebDriverWait wait;
    protected static TestMainPage mp;
    protected static TestProductsCatalog pc;
    protected static HelperPage hp;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers\\\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 7000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1920,1080));

        mp = new TestMainPage();
        pc = new TestProductsCatalog();
        hp = new HelperPage();

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
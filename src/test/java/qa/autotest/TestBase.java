package qa.autotest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static TestHomePage hp;
    protected static TestHelper th;
    protected static TestProductsCatalog pc;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers\\\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 7000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1920,1080));

        hp = new TestHomePage();
        //th = new TestHelper();
        pc = new TestProductsCatalog();
    }



    @After
    public void tearDown(){
        driver.quit();
    }
}

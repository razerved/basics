package qa.autotest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class TestHelper  {

    //private WebDriver driver;

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

    /*public void open(){
        driver.navigate().to(url);
    }
    public TestHelper(WebDriver driver){
        this.driver = driver;
    }*/

}

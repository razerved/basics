package qa.autotest;

import java.util.Random;

public class TestHelper extends TestBase {
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

    protected void findContactsMainPage() {
        try{
            Thread.sleep(2000);
            driver.findElement(hp.contactsInfoLocator).isDisplayed();
        }catch (Exception e){
            System.out.println("[Error]: couldn't find locator");
        }
    }
}

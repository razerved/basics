package qa.autotest;

import java.util.Random;

public class TestHelper  {
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


}

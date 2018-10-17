package java.base;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setProperty;

public class testBase {

    private long time;

    @BeforeSuite
    public void beforeSuit(){
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        time = currentTimeMillis();

    }
 @AfterSuite
    public void afterSuit(){

     System.out.println("Test worked : "  +  (currentTimeMillis() - time) + " ms.");

    }
}

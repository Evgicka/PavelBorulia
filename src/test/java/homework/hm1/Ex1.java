package homework.hm1;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class Ex1 extends TestBase {

    public WebDriver driver;

    @Test
    public void ex1(){
            //1. Open driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

            //2. Open test site by url
        driver.navigate().to("https://epam.github.io/JDI/index.html");

            //3. Check browser title
        assertEquals(driver.getTitle(),"Home Page");

            //4. Log in
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[type = 'submit'")).click();

            //5. Check user name
        assertEquals(driver.findElement(By.cssSelector(".profile-photo")),"PITER CHAINLOVSKII");



    }


}

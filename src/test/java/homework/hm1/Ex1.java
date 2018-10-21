package homework.hm1;
import base.TestBase;
import dataProviders.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Ex1 extends TestBase {

    public WebDriver driver;

    @Test(dataProvider = "headerDataProvider", dataProviderClass = DataProviders.class)
    public void ex1(String headerName, int point){
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
        assertEquals(driver.findElement(By.cssSelector(".profile-photo")).getText(),"PITER CHAILOVSKII");

            //6. Check browser title
        assertEquals(driver.getTitle(),"Home Page");

            //7. check 4 items;
        List<WebElement> headerItems = driver.findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 > li"));
        assertEquals(headerItems.size(),4);
        for (WebElement element : headerItems){
            headerItems.contains(headerName);
        }

            //8.check 4 images
        List<WebElement> images = driver.findElements(By.cssSelector("div.col-sm-3"));
        assertEquals(images.size(),4);
        for (WebElement element : images){
            images.contains(element.isDisplayed());
        }

            //9.check under images
        for (WebElement element : images){
            images.contains(element.getText());
        }

            // close window
        driver.close();



    }


}

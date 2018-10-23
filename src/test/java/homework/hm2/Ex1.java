package homework.hm2;
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
    public void ex1(String headerName, int point) {
        //1. Open driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Open test site by url
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3. Check browser title
        assertEquals(driver.getTitle(), "Home Page");

        //4. Log in
        try {
            driver.findElement(By.cssSelector(".profile-photo")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[type = 'submit'")).click();

        //5. Check user name
        assertEquals(driver.findElement(By.cssSelector(".profile-photo")).getText(), "PITER CHAILOVSKII");

        //6. Check browser title
        assertEquals(driver.getTitle(), "Home Page");

        //7. check 4 items;
        List<WebElement> headerItems = driver.findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 > li"));
        assertEquals(headerItems.size(), 4);
        for (WebElement element : headerItems) {
            headerItems.contains(headerName);
        }

        //8. check 4 images
        List<WebElement> imageColums = driver.findElements(By.cssSelector(".icons-benefit"));
        assertEquals(imageColums.size(), 4);
        for (WebElement element : imageColums) {
            imageColums.contains(element.isDisplayed());
        }


        //9. check texts under images
        List<WebElement> textColums = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(textColums.size(), 4);
        for (WebElement element : textColums) {
            textColums.contains(element.getText());
        }

        //10. check test
        driver.findElement(By.cssSelector("h3.main-title")).isDisplayed();
        assertEquals(driver.findElement(By.cssSelector("h3.main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.cssSelector("p.main-txt.text-center")).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE " +
                "ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT" +
                " IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //11. check iframe and logo in left top
        driver.findElement(By.id("iframe"));
        driver.switchTo().frame("iframe");
        driver.findElement(By.id("epam_logo"));


        //12.Switch to original window back
        driver.switchTo().defaultContent();

        //13.Assert a text of the sub header
        driver.findElement(By.cssSelector("h3.text-center > a")).isDisplayed();
        assertEquals(driver.findElement(By.cssSelector("h3.text-center > a")).getText(),"JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL
        driver.findElement(By.linkText("JDI GITHUB")).isDisplayed();
        assertEquals(driver.findElement(By.cssSelector("h3.text-center > a")).getAttribute("href"), "https://github.com/epam/JDI");

        //15.Assert that there is Left Section
        driver.findElement(By.id("mCSB_1")).isDisplayed();

        //16.footer is displayed
        driver.findElement(By.cssSelector("div.footer-content.overflow")).isDisplayed();

        //17. close browser
        driver.close();


    }


}

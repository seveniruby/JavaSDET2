package webtest.testcase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.IExpectedExceptionsAnnotation;
import webtest.pageboject.firstpage;

public class testframe {

    @Test
    public void mulframe() throws InterruptedException {
        String URL = "https://testerhome.com/topics/19350";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zhicall\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);

        //new WebDriverWait(driver, 5);
        driver.switchTo().frame(0);
        driver.manage().window().maximize();
        driver.findElement(By.partialLinkText("金数据")).click();



//        firstpage firstpage = new firstpage(driver);
//        firstpage.logincookies();

    }

}

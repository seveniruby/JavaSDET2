package webtest.pageboject;

import org.junit.Test;
//import org.mockito.internal.exceptions.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.security.auth.callback.TextInputCallback;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import  org.testng.Reporter;

public class firstpage {

    @FindBy(partialLinkText = "金数据")
    WebElement golddata;

    public  firstpage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void logincookies(){
       // username.clear();
        golddata.click();
            Reporter.log("frame测试",true);
    }





//    @Test
//    //通过cookies进行登录
//    public void loginbycookies() {
//        String URL = "https://work.weixin.qq.com/";
//
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zhicall\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
//        driver.get(URL);
//        driver.manage().window().maximize();
//
//        WebElement element = driver.findElement(By.linkText("企业登录"));
//        element.click();




//        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("hh")));//显示等待
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//隐式等待

//        Actions action = new Actions(driver);
//        action.contextClick(element).perform();
//        driver.switchTo().window("hhh");
//        driver.getWindowHandle();
//        driver.getWindowHandles();



    //添加成员功能
    public void addmenber() {

    }

    //群发消息
    public void sendmessage() {

    }


}

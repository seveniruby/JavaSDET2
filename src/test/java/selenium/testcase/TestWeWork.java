package selenium.testcase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.page.App;

public class TestWeWork {
    public static String url="https://work.weixin.qq.com/";
    @Test
    public void testStart(){
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("企业登录")).click();

        System.out.println(driver.manage().getCookies());

        driver.manage().addCookie(new Cookie("wwrtx.refid", "9156994571588966"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "PvmFAAW3_ZQOnOfp5SzMi6G2ksLVrBXqM1nz3SnTzUm58TfxXhPA3kekfJjTJMK1"));

        driver.navigate().refresh();
        App.driver=driver;

        App app=new App();
        app.toMemberAdd().add();
//        assertThat();

    }
}

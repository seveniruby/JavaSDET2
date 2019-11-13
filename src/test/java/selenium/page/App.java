//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package selenium.page;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App extends BasePage {
    public App() {
    }

    public App loginWithCookie() throws MalformedURLException {
        String url = "https://work.weixin.qq.com/";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("pageLoadStrategy", "none");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zhicall\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("企业登录")).click();
        System.out.println(driver.manage().getCookies());
        driver.manage().addCookie(new Cookie("wwrtx.refid", "25907885701682103"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "vz8lc5ZbIh9dARjpPCqf0fGtpNSNW0GgvnCH0Ko-LjmbLaau-dI0f5Q5W_0BwJ46"));
        driver.navigate().refresh();
        return this;
    }

    public ContactPage toContact() {
        this.findElement(By.linkText("通讯录")).click();
        return new ContactPage();
    }

    public ContactPage toMemberAdd() {
        this.findElement(By.linkText("添加成员")).click();
        return new ContactPage();
    }

    public BroadcastPage toGroupMessage() {
        this.findElement(By.linkText("管理工具")).click();
        this.findElement(By.cssSelector(".ww_icon_AppGroupMessageBig")).click();
        return new BroadcastPage();
    }
}

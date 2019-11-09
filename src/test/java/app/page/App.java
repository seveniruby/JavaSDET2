package app.page;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class App extends BasePage{

    public static void start() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("noReset", false);
        desiredCapabilities.setCapability("autoGrantPermissions", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        new WebDriverWait(driver, 30)
                .until(x -> {
                    System.out.println(System.currentTimeMillis());
                    String xml=driver.getPageSource();
                    Boolean exist=xml.contains("home_search") || xml.contains("image_cancel") ;
                    System.out.println(exist);
                    return exist;
                });


//        //速度会比较慢
//        By adsLocator=By.id("xxx");
//        List<WebElement> ads=driver.findElements(adsLocator);
//        if(ads.size()>=1){
//            ads.get(0).click();
//        }
    }

    public static SearchPage toSearch() {
        click(By.id("com.xueqiu.android:id/home_search"));
        return new SearchPage();
    }

    public static StockPage toStocks(){
        click(By.xpath("//*[contains(@resource-id, 'tab_name') and @text='自选']"));
        return new StockPage();
    }
}

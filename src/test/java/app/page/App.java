package app.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class App extends BasePage{
    private static App app;
    public static App getInstance(){
        if(app==null){
            app=new App();
        }
        return app;
    }

    public void start() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("noReset", false);
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("udid", System.getenv("UDID"));


//        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        URL remoteUrl = new URL("http://192.168.31.199:4444/wd/hub");


        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        long start=System.currentTimeMillis();
        new WebDriverWait(driver, 40)
                .until(x -> {
                    String xml=driver.getPageSource();
                    Boolean exist=xml.contains("home_search") || xml.contains("image_cancel") ;
                    System.out.println((System.currentTimeMillis() - start)/1000);
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

    public SearchPage toSearch() {
//        click(By.id("com.xueqiu.android:id/home_search"));
        parseSteps("/app/page/app.yaml", "toSearch");
        return new SearchPage();
    }

    public StockPage toStocks(){
//        click(By.xpath("//*[contains(@resource-id, 'tab_name') and @text='自选']"));
        parseSteps("/app/page/app.yaml", "toStocks");
        return new StockPage();

    }
}

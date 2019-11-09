package app.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasePage {
    public static AndroidDriver driver;

    public static WebElement findElement(By by) {
        //todo: 递归是更好的

        try {
            return driver.findElement(by);
        } catch (Exception e) {
            handleAlert();

            return driver.findElement(by);
        }
    }

    public static void findElementAndClick(By by) {
        //todo: 递归是更好的

        try {
            driver.findElement(by).click();
        } catch (Exception e) {
            handleAlert();

            driver.findElement(by).click();
        }
    }

    private static void handleAlert() {
        List<By> alertBoxs = new ArrayList<>();
        //todo: 不需要所有的都判断是否存在
        alertBoxs.add(By.id("com.xueqiu.android:id/image_cancel"));
//        alertBoxs.add(By.xpath("dddd"));

        alertBoxs.forEach(alert -> {
            By adsLocator = alert;
            List<WebElement> ads = driver.findElements(adsLocator);
            if (ads.size() >= 1) {
                ads.get(0).click();
            }
        });
    }

    private static void handleAlertByPageSource(){
        //todo: xpath匹配， 标记 定位
        String xml=driver.getPageSource();
        List<String> alertBoxs=new ArrayList<>();
        alertBoxs.add("xxx");
        alertBoxs.add("yyy");

        alertBoxs.forEach(alert -> {
            if(xml.contains(alert)){
                driver.findElement(By.id(alert)).click();
            }
        });

    }

}

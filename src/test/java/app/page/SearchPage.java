package app.page;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.HashMap;

public class SearchPage extends BasePage{
    private By inputBox=By.id("com.xueqiu.android:id/search_input_text");
    private By name=By.id("com.xueqiu.android:id/name");

    public SearchPage search(String keyword) {
        HashMap<String, Object> data=new HashMap<>();
        data.put("keyword", keyword);
        setParams(data);
        parseSteps();
//        App.driver.findElement(inputBox).sendKeys(keyword);
//        click(name);
        return this;
    }

    public Float getCurrentPrice() {
        parseSteps();
//        MobileElement el4 = (MobileElement) findElement(By.id("com.xueqiu.android:id/current_price"));
        return Float.valueOf(getResults().get("price").toString());

    }

    public App cancel(){
//        click(By.id("com.xueqiu.android:id/action_close"));
        parseSteps();
        return new App();

    }

    public SearchPage select(){
//        click(By.id("com.xueqiu.android:id/follow_btn"));
        parseSteps();
        return this;
    }
}

package app.page;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class SearchPage extends BasePage{
    private By inputBox=By.id("com.xueqiu.android:id/search_input_text");

    public SearchPage search(String keyword){
        App.driver.findElement(inputBox).sendKeys(keyword);
        findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).click();
        return this;
    }

    public Float getCurrentPrice() {
        MobileElement el4 = (MobileElement) findElement(By.id("com.xueqiu.android:id/current_price"));
        return Float.valueOf(el4.getText());

    }
}

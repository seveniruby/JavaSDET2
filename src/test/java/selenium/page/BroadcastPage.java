package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class BroadcastPage extends BasePage {
    public BroadcastPage send(String range, String title, String body, String summary, String author){
        findElement(By.linkText("选择需要发消息的应用")).click();
        findElement(By.cssSelector(".ww_icon_AppNotice")).click();
        findElement(By.linkText("确定")).click();
        findElement(By.linkText("选择发送范围")).click();
        //坑1：js执行时间超长，使用page load策略改进
        findElement(By.id("memberSearchInput")).sendKeys(range);
        findElement(By.cssSelector(".ww_searchResult_title_peopleName")).click();
        findElement(By.linkText("确认")).click();
        findElement(By.cssSelector(".ww_editorTitle")).sendKeys(title);
        //坑2：frame切换
        System.out.println(driver.getWindowHandles());
        driver.switchTo().frame(0);
        findElement(By.cssSelector(".msg_noticeEditor_frameBody")).sendKeys(body);
        //坑3：切换回来
        driver.switchTo().defaultContent();

        //坑4：可视化的坑
        ((JavascriptExecutor)(driver)).executeScript("window.scroll(0, 1200)");
        findElement(By.cssSelector(".msg_edit_infoItem_textWord")).click();
        //依赖于上面的一次点击才能出现
        findElement(By.cssSelector(".qui_textarea")).sendKeys(summary);
        findElement(By.cssSelector(".js_amrd_sendName")).sendKeys(author);
        driver.findElements(By.linkText("发送")).forEach(element -> {
            System.out.println(element);
            System.out.println(element.getLocation());
            System.out.println(element.isDisplayed());
        });
        //坑5：两个发送按钮
        ((JavascriptExecutor)(driver)).executeScript("window.scroll(0, 1200)");
        findElement(By.linkText("发送")).click();
        findElement(By.linkText("确定")).click();


        return this;
    }

    public List<String> getSendedMsg(){
        findElement(By.linkText("已发送")).click();
        List<String> msg=new ArrayList<>();
        driver.findElements(By.cssSelector(".msg_history_msgList_td")).forEach(element -> {
            msg.add(element.getText());
        });
        return msg;
    }
}

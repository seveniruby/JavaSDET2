package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

public class ContactPage extends BasePage{
    public ContactPage add(String username, String id, String phone){
        findElement(By.name("username")).sendKeys(username);
        findElement(By.name("acctid")).sendKeys(id);
        findElement(By.name("mobile")).sendKeys(phone);
        findElement(By.linkText("保存")).click();
        return this;

    }

    public ContactPage delete(String keyword){
        findElement(By.id("memberSearchInput")).clear();
        findElement(By.id("memberSearchInput")).sendKeys(keyword);
        try{
            waitClickable(By.linkText("编辑"), 2);
        }catch (Exception e){
            System.out.println("not found");
            return this;
        }

        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确认")).click();

        return this;
    }

    public ContactPage deleteCurrentPage(){
//        findElement(By.cssSelector(".ww_checkbox")).click();
//        Select select=new Select(findElement(By.cssSelector(".ww_checkbox")));
//        select.getFirstSelectedOption().click();
//        select.selectByIndex(0);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitClickable(By.cssSelector(".ww_checkbox"));
        List<WebElement> elements=driver.findElements(By.cssSelector(".ww_checkbox"));
        for(int i=1;i<elements.size();i++){
            System.out.println(i);
            elements.get(i).click();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确认")).click();
        return this;
    }

    public void importFromFile(String path){
        findElement(By.partialLinkText("批量导入/导出")).click();
        findElement(By.linkText("文件导入")).click();
        findElement(By.id("js_upload_file_input"), 0).sendKeys(path);
        findElement(By.id("submit_csv")).click();
        findElement(By.linkText("完成")).click();
    }

    public void list(){

    }

    public HashMap<String, String> getUserInfo(String keyword){
        //todo:
        return new HashMap<>();
    }
}

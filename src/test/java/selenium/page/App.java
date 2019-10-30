package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class App {
    public static WebDriver driver;
    public ContactPage toContact(){
        return new ContactPage();

    }

    public ContactPage toMemberAdd(){
        //find click
        driver.findElement(By.linkText("添加成员")).click();
        return new ContactPage();
    }
}

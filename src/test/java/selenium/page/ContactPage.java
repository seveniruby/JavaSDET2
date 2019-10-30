package selenium.page;

import org.openqa.selenium.By;

public class ContactPage {
    public ContactPage add(String username, String id, String phone){
        App.driver.findElement(By.name("username")).sendKeys(username);
        App.driver.findElement(By.name("acctid")).sendKeys(id);
        App.driver.findElement(By.name("mobile")).sendKeys(phone);
        return this;

    }

    public void list(){

    }
}

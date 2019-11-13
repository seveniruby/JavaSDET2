//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package selenium.testcase;

import java.net.MalformedURLException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import selenium.page.App;

public class TestWeWork {
    public static App app;

    public TestWeWork() {
    }

    @BeforeClass
    public static void beforeAll() throws MalformedURLException {
        app = new App();
        app.loginWithCookie();
        String phone = "18858285384";
        app.toContact().delete(phone);
    }

    @Test
    public void add() {
        String phone = "18858285384";
        app.toMemberAdd().add(phone, phone, phone);
    }

    @Test
    public void delete() {
        String phone = "18858285384";
        app.toMemberAdd().add(phone, phone, phone).delete(phone);
    }

    @Test
    public void deleteCurrentPage() {
        app.toContact().deleteCurrentPage();
    }

    @Test
    public void importFromFile() {
        app.toContact().importFromFile("E://UIAUTO/通讯录批量导入模板.xlsx");
    }

    @AfterClass
    public static void afterAll() throws InterruptedException {
        app.quit();
    }
}

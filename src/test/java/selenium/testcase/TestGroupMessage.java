package selenium.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import selenium.page.App;

import java.net.MalformedURLException;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

public class TestGroupMessage {

    public static App app;
    @BeforeClass
    public static void beforeAll() throws MalformedURLException {
        app=new App();
        app.loginWithCookie();
    }

    @Test
    public void send(){
        String title="你的快递已到"+System.currentTimeMillis();
        List<String> sendedMsg = app.toGroupMessage()
                .send("思寒", title, title + title,
                        "快递通知", "霍格沃兹测试学院")
                .getSendedMsg().subList(0, 5);
        System.out.println(sendedMsg);
        assertThat(sendedMsg, hasItem(title));


    }
}

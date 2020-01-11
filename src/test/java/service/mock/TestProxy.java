package service.mock;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.junit.jupiter.api.Test;

public class TestProxy {

    @Test
    void mockOnProxy(){
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(8091);
        proxy.addResponseFilter( ((httpResponse, httpMessageContents, httpMessageInfo) -> {
            httpMessageContents.setTextContents(httpMessageContents.getTextContents().replace("", ""));
        }));
    }
}

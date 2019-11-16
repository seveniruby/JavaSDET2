package app.page;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class PageObjectModel {
    public HashMap<String, PageObjectElement> elements=new HashMap<>();
    public HashMap<String, PageObjectMethod> methods=new HashMap<>();
    public PageObjectMethod getMethod(String method){
        return methods.get(method);
    }

    public void run(String method){
        methods.get(method).getSteps().forEach(step->{
            WebElement element = null;

            //todo: 多个可能定位，多平台支持，多版本的支持
            String id=step.get("id");
            if(id!=null){
                element=BasePage.driver.findElement(By.id(id));
            }else if(step.get("xpath")!=null){
                element=BasePage.driver.findElement(By.xpath(step.get("xpath")));
            }else if(step.get("aid")!=null){
                element=BasePage.driver.findElement(MobileBy.AccessibilityId(step.get("aid")));
            }else if(step.get("element")!=null){
                element=BasePage.driver.findElement(elements.get(step.get("element")).getLocator());
            }

            String send=step.get("send");
//            params.entrySet().forEach(kv->{
//                send=send.replace("{"+ kv.getKey() +"}", kv.getValue().toString());
//            });



            if(send!=null){
                //配置文件中的参数替换
                for(Map.Entry<String, Object> kv: BasePage.getParams().entrySet()){
                    String matcher="${"+kv.getKey()+"}";
                    if(send.contains(matcher)) {
                        System.out.println(kv);
                        send = send.replace(matcher, kv.getValue().toString());
                    }
                }
                element.sendKeys(send);

            }else if(step.get("get")!=null){
                String attribute=element.getAttribute(step.get("get"));
                BasePage.getResults().put(step.get("dump"), attribute);

            }else{
                element.click();
            }

        });
    }


}

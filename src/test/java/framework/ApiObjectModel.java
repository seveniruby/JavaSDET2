package framework;

import app.page.BasePage;
import io.appium.java_client.MobileBy;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class ApiObjectModel {
    //    public HashMap<String, PageObjectElement> elements = new HashMap<>();
    public HashMap<String, ApiObjectMethodModel> methods = new HashMap<>();

    public ApiObjectMethodModel getMethod(String method) {
        return methods.get(method);
    }

    public Response run(String method) {
        return getMethod(method).run();
    }

    public Response run(String method, HashMap<String, Object> params) {
        return getMethod(method).run(params);
    }
}

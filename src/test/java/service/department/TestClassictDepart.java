package service.department;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestClassictDepart {
    static String token;
    static int parentDepartId=532;
    @BeforeAll
    public static void getToken() {

        RestAssured.proxy(8888);

        token=given()
                .param("corpid", "wwd6da61649bd66fea")
                .param("corpsecret", "C7uGOrNyxWWzwBsUyWEbLdbZBDrc71PNOhyQ_YYPhts")
        .when()
                .log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
        .then()
                .log().all()
                .body("errcode", equalTo(0))
        .extract()
                .body().path("access_token");
        System.out.println(token);
    }

    @Test
    public void departCreate(){
        HashMap<String, Object> data=new HashMap<>();
        data.put("name", "部门1");
        data.put("parentid", parentDepartId);

        given()
                .queryParam("access_token", token)
                .contentType(ContentType.JSON)
                .body(data)
        .when().log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
        .then().log().all()
                .body("errcode", equalTo(0));

        //todo: 需要用list接口校验，但是如果编写list的请求，会导致代码冗余带来维护问题，所以引入po思想
    }

    @Test
    public void departList(){
        given()
                .queryParam("access_token", token)
                .queryParam("id", parentDepartId)
        .when().log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
        .then().log().all()
                .body("errcode", equalTo(0));

    }
}

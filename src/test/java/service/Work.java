package service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Work {
    private static Work work;
    String token;

    public static Work getInstance() {
        if (work == null) {
            work = new Work();
        }
        return work;
    }


    public String getToken() {
        if (token == null) {
            token = given()
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

        return token;
    }
}

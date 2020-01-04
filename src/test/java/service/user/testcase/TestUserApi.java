package service.user.testcase;

import org.junit.jupiter.api.Test;
import service.user.api.UserApi;

import static org.hamcrest.Matchers.equalTo;

public class TestUserApi {
    @Test
    public void get(){
        UserApi user=new UserApi();
        user.get("seveniruby").then().body("errcode", equalTo(0));
    }
}

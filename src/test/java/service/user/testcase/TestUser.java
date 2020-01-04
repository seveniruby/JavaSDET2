package service.user.testcase;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.junit.jupiter.api.Test;
import service.user.api.User;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class TestUser {

    @Test
    public void info() {
        User user = new User();
        user.get("seveniruby1564217505.480352").then()
                .body("name", equalTo("seveniruby 1564912419.113182"));
    }

    @Test
    public void update() {
        //todo: add more testcase
        User user = new User();
        String userid = "seveniruby1564217505.480352";
        String nameNew = "name for testing";
//        user.update("xxx", "name", "ddddd");
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", nameNew);
        data.put("address", "address for testing");
        user.update(userid, data);
        user.get(userid).then().body("name", equalTo(nameNew));
    }

    @Test
    public void create() {
        String nameNew = "name for testing";
        String userid = "seveniruby_" + System.currentTimeMillis();


        HashMap<String, Object> data = new HashMap<>();
        data.put("name", nameNew);
        data.put("department", new int[]{1});
        data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0, 11));
        data.put("address", "address for testing");

        User user = new User();
        user.create(userid, data).then().body("errcode", equalTo(0));

        user.get(userid).then().body("name", equalTo(nameNew));
    }

    @Test
    public void cloneUser() {
        String nameNew = "name for testing";
        String userid = "seveniruby_" + System.currentTimeMillis();

        HashMap<String, Object> data = new HashMap<>();
        data.put("name", nameNew);
//        data.put("department", new int[]{1});
        data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0, 11));

        User user = new User();
        user.clone(userid, data).then().body("errcode", equalTo(0));

        user.get(userid).then().body("name", equalTo(nameNew));
    }

    @Test
    public void delete() {
        String nameNew = "name for testing";
        String userid = "seveniruby_" + System.currentTimeMillis();

        HashMap<String, Object> data = new HashMap<>();
        data.put("name", nameNew);
//        data.put("department", new int[]{1});
        data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0, 11));

        User user = new User();
        user.clone(userid, data).then().body("errcode", equalTo(0));

        user.delete(userid).then().body("errcode", equalTo(0));
        user.get(userid).then().body("errcode", not(equalTo(0)));
    }

    //todo: 获取部门成员列表

    //todo: 批量删除成员

}

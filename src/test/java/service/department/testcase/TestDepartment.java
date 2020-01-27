package service.department.testcase;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.department.api.Department;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class TestDepartment {

    static Department department = new Department();

    @BeforeAll
    public static void beforeAll() {

        //数据清理
        ArrayList<Integer> ids = department.list(department.parentDepartId).then()
                .extract().body().path("department.findAll {d->d.parentid==" + department.parentDepartId + " }.id");
        System.out.println(ids);
        ids.forEach(id -> department.delete(id));

    }

    @Test
    public void list() {
        //depart.list(522).assert()
        department.list(department.parentDepartId).then().body("errmsg", equalTo("ok"));
    }

    @Test
    public void create() {
        String name = "部门2";
        department.create(name).then().body("errmsg", equalTo("created"));
        department.list(department.parentDepartId)
                .then().body("department.findAll {d->d.name=='" + name + "' }.id", hasSize(1));
    }


    @Test
    public void delete() {
        int id = department.create("部门3").then().body("errmsg", equalTo("created"))
                .extract().body().path("id");
        System.out.println(id);
        department.delete(id).then().body("errmsg", equalTo("deleted"));

    }
}

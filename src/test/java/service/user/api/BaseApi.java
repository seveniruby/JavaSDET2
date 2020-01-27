package service.user.api;

import app.page.BasePage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import framework.ApiObjectModel;
import framework.PageObjectModel;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;

public class BaseApi {
    ApiObjectModel model = new ApiObjectModel();
    HashMap<String, Object> params;

    public Response parseSteps() {
        String method = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println(method);

        if(model.methods.entrySet().isEmpty()) {
            System.out.println("pom first load");
            String path = "/" + this.getClass().getCanonicalName().replace('.', '/') + ".yaml";
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            try {
                model = mapper.readValue(
                        BaseApi.class.getResourceAsStream(path), ApiObjectModel.class
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (Response) model.run(method, params);


    }

    public void setParams(HashMap<String, Object> data){
        params=data;
    }
}

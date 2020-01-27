package unit;

import app.page.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import framework.PageObjectElement;
import framework.PageObjectMethod;
import framework.PageObjectModel;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TestSteps {
    @Test
    public void  steps() throws JsonProcessingException {
        HashMap<String, PageObjectMethod> testcase=new HashMap<String, PageObjectMethod>();
        PageObjectMethod testcaseStep=new PageObjectMethod();
        List<HashMap<String, Object>> steps=new ArrayList<>();

        HashMap<String, Object> map=new HashMap<>();
        map.put("id", "xxxx");
        map.put("send", "xxxx");
        steps.add(map);
        steps.add(map);

        testcaseStep.setSteps(steps);
        testcase.put("search", testcaseStep);


        ObjectMapper mapper=new ObjectMapper(new YAMLFactory());
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(testcase));
    }

    @Test
    public void parseSteps() throws MalformedURLException {
        App.getInstance().start();
        BasePage basePage=new BasePage();
        basePage.parseSteps("search");
    }
    @Test
    public void demo(){
        Arrays.stream(Thread.currentThread().getStackTrace()).forEach(stack->{
            System.out.println(stack.getClassName()+ ":" + stack.getMethodName());
        });

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    public void testPOM() throws JsonProcessingException {
        PageObjectModel model=new PageObjectModel();
        PageObjectElement element=new PageObjectElement();

        HashMap<String, String> map2=new HashMap<>();
        map2.put("id", "xxxx");
        map2.put("xpath", "xxxx");

        element.element.add(map2);
        model.elements.put("search_locator", element);

        PageObjectMethod method=new PageObjectMethod();
        List<HashMap<String, Object>> steps=new ArrayList<>();

        HashMap<String, Object> map=new HashMap<>();
        map.put("id", "xxxx");
        map.put("send", "xxxx");
        steps.add(map);
        steps.add(map);
        method.setSteps(steps);
        model.methods.put("search", method);
        ObjectMapper mapper=new ObjectMapper(new YAMLFactory());

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(model));

    }
}

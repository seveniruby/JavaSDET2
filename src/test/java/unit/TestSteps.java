package unit;

import app.page.App;
import app.page.BasePage;
import app.page.TestCaseSteps;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestSteps {
    @Test
    public void  steps() throws JsonProcessingException {
        HashMap<String, TestCaseSteps> testcase=new HashMap<String, TestCaseSteps>();
        TestCaseSteps testcaseStep=new TestCaseSteps();
        List<HashMap<String, String>> steps=new ArrayList<>();

        HashMap<String, String> map=new HashMap<>();
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
        App.start();
        BasePage basePage=new BasePage();
        basePage.parseSteps("search");
    }
}

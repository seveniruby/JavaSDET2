package framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PageObjectMethod {
    private List<HashMap<String, Object>> steps;

    public List<HashMap<String, Object>> getSteps() {
        return steps;
    }

    public void setSteps(List<HashMap<String, Object>> steps) {
        this.steps = steps;
    }
}

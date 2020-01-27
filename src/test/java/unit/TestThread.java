package unit;

import org.junit.jupiter.api.Test;

public class TestThread {
    @Test
    void demo(){
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            System.out.println(stackTraceElement.getClassName() + ":" + stackTraceElement.getMethodName());
        }
    }
}

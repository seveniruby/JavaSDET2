package unit;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

public class TestGroups {

    @Category({SlowGroup.class, FastGroup.class})
    @Test
    public void testDemo1(){
        assertTrue(false);
    }

    @Category(SlowGroup.class)
    @Test
    public void testDemo2(){
        assertEquals("diff two values", 100, 10);
        assertTrue(false);
    }

    @Category(SlowGroup.class)
    @Test
    public void testDemo3(){
        assertThat("actual value close to 10",
                9.88,
                anyOf(closeTo(10.0, 0.1), equalTo(9.88) ));
    }


    @Category(FastGroup.class)
    @Test
    public void testDemo4(){
        assertTrue(false);
    }
}

package unit;

import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJUnit4DemoChildren extends TestJUnit4Demo {

    @BeforeClass
    public static void beforeAllTestCaseChildren(){
        System.out.println("unit.TestJUnit4DemoChildren beforeAllTestCase");
    }

    @AfterClass
    public static void afterAllTestCaseChildren(){
        System.out.println("unit.TestJUnit4DemoChildren afterAllTestCase");
    }

    @Before
    public void beforeTestCaseChildren(){
        System.out.println("unit.TestJUnit4DemoChildren i am @before");
    }

    @After
    public void afterTestCaseChildren(){
        System.out.println("unit.TestJUnit4DemoChildren i am @after");
    }

    @Test
    public void testDemo3Children(){
        System.out.println("unit.TestJUnit4DemoChildren testDemo3");
        assertTrue(false);
    }

    @Test
    public void testDemo1Children(){
        System.out.println("unit.TestJUnit4DemoChildren testDemo1");
        assertTrue(true);
    }

    @Test
    public void testDemo2Children(){
        System.out.println("unit.TestJUnit4DemoChildren testDemo2");
        assertTrue(false);
    }

}

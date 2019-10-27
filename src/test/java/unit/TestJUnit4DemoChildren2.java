package unit;

import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJUnit4DemoChildren2 extends TestJUnit4Demo {

    @BeforeClass
    public static void beforeAllTestCaseChildren2(){
        System.out.println("unit.TestJUnit4DemoChildren2 beforeAllTestCase");
    }

    @AfterClass
    public static void afterAllTestCaseChildren2(){
        System.out.println("unit.TestJUnit4DemoChildren2 afterAllTestCase");
    }

    @Before
    public void beforeTestCaseChildren2(){
        System.out.println("unit.TestJUnit4DemoChildren2 i am @before");
    }

    @After
    public void afterTestCaseChildren2(){
        System.out.println("unit.TestJUnit4DemoChildren2 i am @after");
    }

    @Test
    public void testDemo3Children2(){
        System.out.println("unit.TestJUnit4DemoChildren2 testDemo3");
        assertTrue(false);
    }

    @Test
    public void testDemo1Children2(){
        System.out.println("unit.TestJUnit4DemoChildren2 testDemo1");
        assertTrue(true);
    }

    @Test
    public void testDemo2Children2(){
        System.out.println("unit.TestJUnit4DemoChildren2 testDemo2");
        assertTrue(false);
    }

}

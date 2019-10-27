package mock;

import mock.Division;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class DivisionTest {

    Division division=new Division();
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void divid() {
        assertThat(division.divid(10, 5), equalTo(2));
    }

    @Test
    public void dividReturnWithZero(){
        assertThat(division.divid(1, 2), equalTo(0));
    }

    @Test
    public void dividByZero(){
        assertThat(division.divid(100, 0), equalTo(null));
    }

//    @Test
//    public void dividWithAG100(){
//        assertThat(division.divid(1000, 20), equalTo(null));
//    }
}
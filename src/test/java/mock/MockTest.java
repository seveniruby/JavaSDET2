package mock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class MockTest {
    @Test
    public void testMockDemo(){
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        assertThat(list.size(), equalTo(5));

    }

    @Test
    public void testMockDemo2(){
        ArrayList<Integer> list=mock(ArrayList.class);
        list.add(1);
        list.add(2);
        when(list.size()).thenReturn(500);
        assertThat(list.size(), equalTo(500));

    }

    @Test
    public void testSpy(){
        ArrayList<Integer> list=mock(ArrayList.class);
        list.add(1);
        list.add(2);
        verify(list).add(3);
    }
}

package app.testcase;

import app.page.App;
import app.page.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class TestSearch {
    public static SearchPage searchPage;
    @BeforeClass
    public static void beforeAll() throws MalformedURLException {
        App.start();

    }

    @Parameterized.Parameters
    public static List<String> data(){
        List<String> stocks=new ArrayList<>();
        stocks.add("xiaomi");
        stocks.add("alibaba");
        stocks.add("jd");
        return stocks;
    }

    @Parameterized.Parameter
    public String stock;

    @Before
    public void before(){
        searchPage=App.toSearch();
    }
    @Test
    public void search(){
        assertThat(searchPage.search(stock).getCurrentPrice(), greaterThanOrEqualTo(120f));
    }
    @After
    public void after(){
        searchPage.cancel();
    }
}

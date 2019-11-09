package app.testcase;

import app.page.App;
import app.page.SearchPage;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

public class TestSearch {
    public static SearchPage searchPage;
    @BeforeClass
    public static void beforeAll() throws MalformedURLException {
        App.start();
        searchPage=App.toSearch();
    }
    @Test
    public void search(){
        assertThat(searchPage.search("alibaba").getCurrentPrice(), greaterThanOrEqualTo(120f));

    }
}

package app.testcase;

import app.page.App;
import app.page.StockPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class TestStock {
    private static StockPage stockPage;
    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        App.start();
        stockPage=App.toStocks();

    }
    @BeforeEach
    public void beforeEach(){

    }
    @Test
    public void addDefaultSelectedStocks(){
        if(stockPage.getAllStocks().size()>=1){
            stockPage.deleteAll();
        }
        assertThat(stockPage.addDefaultSelectedStocks().getAllStocks().size(), greaterThanOrEqualTo(6));
    }
}

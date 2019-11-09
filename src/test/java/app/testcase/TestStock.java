package app.testcase;

import app.page.App;
import app.page.StockPage;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(100)
    @Test
    public void addDefaultSelectedStocks(){
        if(stockPage.getAllStocks().size()>=1){
            stockPage.deleteAll();
        }
        assertThat(stockPage.addDefaultSelectedStocks().getAllStocks().size(), greaterThanOrEqualTo(6));
    }

    @Order(200)
    @Test
    public void addStock(){
        stockPage.toSearch().search("pdd").select().cancel();
        assertThat(stockPage.getAllStocks(), hasItem("拼多多"));

    }

}

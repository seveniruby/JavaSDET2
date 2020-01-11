package service.mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class TestMock {
    static WireMockServer wireMockServer;

    @BeforeAll
    static void beforeAll() {
        wireMockServer = new WireMockServer(options().port(8089)); //No-args constructor will start on port 8080, no HTTPS
        wireMockServer.start();
        configureFor("localhost", 8089);
        System.out.println("mock server start");
    }

    @Test
    void stub() {
        stubFor(get(urlEqualTo("/stub")).willReturn(aResponse().withBody("stub demo")));

        given()
                .when().log().all().get("http://127.0.0.1:8089/stub")
                .then().log().all().body(containsString("stub"));

    }


    @Test
    void mock() throws InterruptedException {
        // Low priority catch-all proxies to otherhost.com by default
        stubFor(get(urlMatching(".*")).atPriority(10)
                .willReturn(aResponse().proxiedFrom("http://106.75.214.88")));


// High priority stub will send a Service Unavailable response
// if the specified URL is requested
        stubFor(get(urlEqualTo("/api/v3/topics.json")).atPriority(1)
                .willReturn(aResponse().withStatus(200).withBody("demo")));

        Thread.sleep(100000);
    }

    @AfterAll
    static void afterAll() {
        wireMockServer.stop();
    }
}

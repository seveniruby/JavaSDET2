package service.dubbo.consumer;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import service.dubbo.inter.GreetingsService;

public class TestDubbo {
    static GreetingsService service;

    @BeforeAll
    static void beforeAll() {
        String zookeeperHost = System.getProperty("zookeeper.address", "127.0.0.1");

        ReferenceConfig<GreetingsService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("first-dubbo-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
        reference.setInterface(GreetingsService.class);
        service = reference.get();

    }

    @ParameterizedTest
    @ValueSource(strings = {"dubbo", "seveniruby", "hogwarts"})
    void sayHi(String name){
        String message = service.sayHi(name);
        System.out.println(message);
    }
}
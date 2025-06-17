package com.cqrs.demo;

import com.cqrs.demo.configuration.AppTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest(properties = {
        "spring.liquibase.enabled=false"
})
@Import(AppTestConfiguration.class)
public class AnotherTests {

    @Test
    void contextLoads() {
    }
}

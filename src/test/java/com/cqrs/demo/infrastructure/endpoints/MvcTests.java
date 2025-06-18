package com.cqrs.demo.infrastructure.endpoints;

import com.cqrs.demo.configuration.AppTestConfiguration;
import com.cqrs.demo.infrastructure.repositories.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = {
        "spring.liquibase.enabled=false"
})
@AutoConfigureMockMvc
@Import(AppTestConfiguration.class)
class MvcTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private OrderRepository orderWriteRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    void fakeEndpointNotFoundTest() {
        this.mvc.perform(get("/fake/endpoint"))
                .andExpect(status().isNotFound());
    }

    @Test
    @SneakyThrows
    void ordersEndpointTest() {
        this.mvc.perform(get("/api/v1/orders"))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    @Disabled
    void ordersEndpointTestToDo() {// ToDO
        final var response = this.mvc.perform(get("/api/v1/orders/"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        final var result = objectMapper.readValue(response, OrderResponse.class);
        assertEquals(result.country(), "UA");
    }
}

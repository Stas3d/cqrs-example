package com.cqrs.demo.infrastructure.endpoints;

import com.cqrs.demo.configuration.AppTestConfiguration;
import com.cqrs.demo.infrastructure.repositories.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = {
        "spring.liquibase.enabled=false"
})
@AutoConfigureMockMvc
@Import(AppTestConfiguration.class)
class OrderControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private OrderRepository orderWriteRepository;

    @Autowired
    private ObjectMapper mapper;

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
    void createOrderTest() {

        final var value = mapper.writeValueAsString(new OrderRequest("first", "last", "UA"));
        final var response = this.mvc.perform(post("/api/v1/orders")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(value))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        final var uuid = mapper.readValue(response, CreateOrderResponse.class).id();

        assertNotNull(uuid);
    }
}

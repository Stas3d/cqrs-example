package com.cqrs.demo.controller;

import com.cqrs.demo.service.AddOrderCommand;
import com.cqrs.demo.service.GetOrderQuery;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/orders")
class OrderController {
    private final GetOrderQuery getOrderQuery;
    private final AddOrderCommand addOrderCommand;

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> fetch(@PathVariable long id) {
        final var output = getOrderQuery.execute(id);
        return new ResponseEntity<>(OrderResponse.of(output), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NewOrderResponse> create(@RequestBody OrderRequest request) {
        final var id = addOrderCommand.execute(request.toCommandInput());
        return new ResponseEntity<>(new NewOrderResponse(id), HttpStatus.CREATED);
    }
}

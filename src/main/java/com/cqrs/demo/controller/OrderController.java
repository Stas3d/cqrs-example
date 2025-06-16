package com.cqrs.demo.controller;

import com.cqrs.demo.service.AddOrderCommand;
import com.cqrs.demo.service.GetOrderQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("public/v1/orders")
class OrderController {
    private final GetOrderQuery getOrderQuery;
    private final AddOrderCommand addOrderCommand;

    @GetMapping("/id")
    public ResponseEntity<OrderResponse> getOrder(Long id) {
        final var output = getOrderQuery.execute(id);
        return new ResponseEntity<>(OrderResponse.of(output), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody OrderRequest request) {
        final var id = addOrderCommand.execute(request.toCommandInput());
        return new ResponseEntity<>(new CreateOrderResponse(id), HttpStatus.CREATED);
    }
}

package com.cqrs.demo.infrastructure.endpoints;

import com.cqrs.demo.domain.AddOrderCommand;
import com.cqrs.demo.domain.GetOrderByIdQuery;

import com.cqrs.demo.domain.GetOrdersQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/orders")
class OrderController {
    private final AddOrderCommand addOrderCommand;
    private final GetOrdersQuery getOrdersQuery;
    private final GetOrderByIdQuery getOrderByIdQuery;

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> fetchById(@PathVariable long id) {
        final var output = getOrderByIdQuery.execute(id);
        return new ResponseEntity<>(OrderResponse.of(output), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<OrderResponse>> fetchAll() {
        final var orderList = getOrdersQuery.execute()
                .stream()
                .map(OrderResponse::of)
                .collect(Collectors.toList());
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponse> create(@RequestBody OrderRequest request) {
        final var id = addOrderCommand.execute(request.toCommandInput());
        return new ResponseEntity<>(new CreateOrderResponse(id), HttpStatus.CREATED);
    }
}

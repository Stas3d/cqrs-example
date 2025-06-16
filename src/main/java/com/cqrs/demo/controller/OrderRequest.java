package com.cqrs.demo.controller;

import com.cqrs.demo.service.AddOrderCommand;
import lombok.NonNull;
import lombok.Value;

@Value
public class OrderRequest {

    private static final String DEFAULT_CREATED = "created";

    @NonNull
    String orderNumber;
    @NonNull
    String name;
    @NonNull
    String lastName;
    @NonNull
    String country;
    @NonNull
    String status;

    public AddOrderCommand.Input toCommandInput() {
        return new AddOrderCommand.Input(orderNumber, name, lastName, country, status);
    }
}
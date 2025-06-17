package com.cqrs.demo.controller;

import com.cqrs.demo.service.AddOrderCommand;
import lombok.NonNull;

record OrderRequest(
        @NonNull String userId,
        @NonNull String firstName,
        @NonNull String lastName,
        @NonNull String country
) {

    AddOrderCommand.Input toCommandInput() {
        return new AddOrderCommand.Input(userId, firstName, lastName, country);
    }
}
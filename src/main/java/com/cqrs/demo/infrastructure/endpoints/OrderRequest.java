package com.cqrs.demo.infrastructure.endpoints;

import com.cqrs.demo.domain.AddOrderCommand;
import lombok.NonNull;

record OrderRequest(
        @NonNull String firstName,
        @NonNull String lastName,
        @NonNull String country
) {

    AddOrderCommand.Input toCommandInput() {
        return new AddOrderCommand.Input(firstName, lastName, country);
    }
}
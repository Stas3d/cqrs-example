package com.cqrs.demo.infrastructure.store.entities;

import com.cqrs.demo.dto.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "orders_view")
@NoArgsConstructor
public class OrderViewEntity {

    @Column(name = "order_number")
    @Id
    private UUID orderNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "country")
    private String country;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @Column(name = "created_at")
    private Date createdAt;

    public OrderViewEntity(UUID orderNumber, String firstName, String lastName, String country) {
        this.orderNumber = orderNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.status = OrderStatus.CREATED;
    }
}

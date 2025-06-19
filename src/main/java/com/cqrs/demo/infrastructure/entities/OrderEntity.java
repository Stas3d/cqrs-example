package com.cqrs.demo.infrastructure.entities;

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
@Table(name = "orders")
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id", nullable = false)
    private Long id;

    @Column(name = "order_number", nullable = false, unique = true)
    private UUID orderNumber;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "country")
    private String country;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @Column(name = "created_at")
    private Date createdAt;

    public OrderEntity(UUID orderNumber, String firstName, String lastName, String country) {
        this.orderNumber = orderNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.status = OrderStatus.CREATED;
    }
}

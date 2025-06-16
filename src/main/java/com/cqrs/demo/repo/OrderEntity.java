package com.cqrs.demo.repo;

import com.cqrs.demo.dto.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Getter
@Setter
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private UUID orderNumber;
    private String name;
    private String lastName;
    private String country;
    private OrderStatus status;
    private String time;
}

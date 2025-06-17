package com.cqrs.demo.repo;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean // READ ONLY CrudRepository !
public interface OrderViewRepository<OrderMVEntity, Long> extends Repository<OrderViewEntity, Long> {

    Optional<OrderMVEntity> findById(long id);

    List<OrderMVEntity> findAll();
}

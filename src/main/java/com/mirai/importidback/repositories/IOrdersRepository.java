package com.mirai.importidback.repositories;

import com.mirai.importidback.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdersRepository extends JpaRepository<Orders,Long> {
}

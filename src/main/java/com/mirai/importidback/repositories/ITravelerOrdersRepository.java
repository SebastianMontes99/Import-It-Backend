package com.mirai.importidback.repositories;

import com.mirai.importidback.entities.TravelerOrders;
import com.mirai.importidback.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITravelerOrdersRepository extends JpaRepository<TravelerOrders,Long> {
}

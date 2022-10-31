package com.mirai.importidback.repositories;

import com.mirai.importidback.entities.ProductWholesale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductWholesaleRepository extends JpaRepository<ProductWholesale,Long> {
}

package com.mirai.importidback.repositories;

import com.mirai.importidback.entities.DomesticShipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDomesticShipmentRepository extends JpaRepository<DomesticShipment,Long> {
}

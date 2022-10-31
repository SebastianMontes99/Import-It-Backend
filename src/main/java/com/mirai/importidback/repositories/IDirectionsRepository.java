package com.mirai.importidback.repositories;

import com.mirai.importidback.entities.Directions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDirectionsRepository extends JpaRepository<Directions,Long> {
}

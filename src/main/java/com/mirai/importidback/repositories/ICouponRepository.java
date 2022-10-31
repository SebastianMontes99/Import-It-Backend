package com.mirai.importidback.repositories;


import com.mirai.importidback.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICouponRepository extends JpaRepository<Coupon,Long> {
    Coupon findByCode(String code);
}

package com.mirai.importidback.services;

import com.mirai.importidback.entities.Coupon;

public interface ICouponService extends CrudService<Coupon>{

    Coupon findByCode(String code) throws Exception;
}

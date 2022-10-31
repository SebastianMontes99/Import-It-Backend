package com.mirai.importidback.services.impl;

import com.mirai.importidback.entities.DomesticShipment;
import com.mirai.importidback.repositories.IDomesticShipmentRepository;
import com.mirai.importidback.services.IDomesticShipmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class DomesticShipmentServiceImpl implements IDomesticShipmentService {

    private final IDomesticShipmentRepository domesticShipmentRepository;

    public DomesticShipmentServiceImpl(IDomesticShipmentRepository domesticShipmentRepository) {
        this.domesticShipmentRepository = domesticShipmentRepository;
    }

    @Override
    @Transactional
    public DomesticShipment save(DomesticShipment domesticShipment) throws Exception {
        return domesticShipmentRepository.save(domesticShipment);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        domesticShipmentRepository.deleteById(id);
    }

    @Override
    public List<DomesticShipment> getAll() throws Exception {
        return domesticShipmentRepository.findAll();
    }

    @Override
    public Optional<DomesticShipment> getById(Long id) throws Exception {
        return domesticShipmentRepository.findById(id);
    }
}

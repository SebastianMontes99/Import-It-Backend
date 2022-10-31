package com.mirai.importidback.services.impl;

import com.mirai.importidback.entities.Directions;
import com.mirai.importidback.repositories.IDirectionsRepository;
import com.mirai.importidback.services.IDirectionsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DirectionsServiceImpl implements IDirectionsService {

    private final IDirectionsRepository directionsRepository;

    public DirectionsServiceImpl(IDirectionsRepository directionsRepository) {this.directionsRepository = directionsRepository;}

    @Override
    @Transactional
    public Directions save(Directions directions) throws Exception {
        return directionsRepository.save(directions);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        directionsRepository.deleteById(id);
    }

    @Override
    public List<Directions> getAll() throws Exception {
        return directionsRepository.findAll();
    }

    @Override
    public Optional<Directions> getById(Long id) throws Exception {
        return directionsRepository.findById(id);
    }
}

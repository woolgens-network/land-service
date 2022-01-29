package net.woolgens.scaffold.service;

import io.quarkus.cache.CacheResult;
import net.woolgens.scaffold.model.dto.LandNameDto;
import net.woolgens.scaffold.repository.LandRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@ApplicationScoped
public class LandService {

    @Inject
    LandRepository repository;


    @CacheResult(cacheName = "land-small")
    public List<LandNameDto> getAllSmallProjectedLands() {
        return repository.findAll().project(LandNameDto.class).list();
    }
}

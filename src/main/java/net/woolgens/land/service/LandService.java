package net.woolgens.land.service;

import io.quarkus.cache.CacheResult;
import io.quarkus.mongodb.panache.PanacheQuery;
import io.quarkus.panache.common.Sort;
import net.woolgens.land.model.Land;
import net.woolgens.land.model.dto.LandNameDto;
import net.woolgens.land.repository.LandRepository;

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

    public List<Land> getAllSortedAndPaged(String sorted, String pageIndex, String pageSize) {
        PanacheQuery<Land> query = repository.findAll(Sort.descending(sorted));
        if(pageIndex != null && pageSize != null) {
            try {
                query.page(Integer.valueOf(pageIndex), Integer.valueOf(pageSize));
            }catch (NumberFormatException ex) {}
        }
        return query.list();
    }
}

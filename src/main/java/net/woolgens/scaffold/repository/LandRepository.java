package net.woolgens.scaffold.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import net.woolgens.scaffold.model.Land;

import javax.enterprise.context.ApplicationScoped;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@ApplicationScoped
public class LandRepository implements PanacheMongoRepositoryBase<Land, String> {
}

package net.woolgens.land.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import net.woolgens.land.model.bank.LandBank;
import org.bson.codecs.pojo.annotations.BsonId;

import java.util.Map;
import java.util.Set;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@Data
@MongoEntity(collection = "lands")
public class Land {

    @BsonId
    private String id;

    private String name;
    private long registered;

    private LandMember owner;
    private Map<String, LandRole> roles;
    private Map<String, LandMember> members;
    private Map<String, Integer> upgrades;
    private Set<LandChunk> chunks;
    private LandBank bank;
    private LandSettings settings;

    private Set<String> invites;

}

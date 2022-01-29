package net.woolgens.scaffold.model.dto;

import io.quarkus.mongodb.panache.common.ProjectionFor;
import lombok.Getter;
import lombok.Setter;
import net.woolgens.scaffold.model.Land;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@Getter @Setter
@ProjectionFor(Land.class)
public class LandNameDto {

    private String name;
}

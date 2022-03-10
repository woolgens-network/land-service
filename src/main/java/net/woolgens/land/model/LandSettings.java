package net.woolgens.land.model;

import lombok.Data;

import java.util.Map;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@Data
public class LandSettings {

    private String homeLocationValue;
    private Map<String, Object> properties;
}

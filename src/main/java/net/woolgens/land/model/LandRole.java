package net.woolgens.land.model;

import lombok.Data;

import java.util.Set;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@Data
public class LandRole {

    private String name;
    private String color;
    private int priority;
    private boolean defaultRole;
    private Set<String> permissions;
}

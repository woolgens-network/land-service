package net.woolgens.scaffold.exception.impl;

import net.woolgens.scaffold.exception.LandException;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
public class LandNotFoundException extends LandException {

    public LandNotFoundException() {
        super(404, "Land not found");
    }
}

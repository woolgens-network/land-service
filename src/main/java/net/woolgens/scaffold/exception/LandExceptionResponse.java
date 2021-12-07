package net.woolgens.scaffold.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LandExceptionResponse {

    private int status;
    private String message;
}

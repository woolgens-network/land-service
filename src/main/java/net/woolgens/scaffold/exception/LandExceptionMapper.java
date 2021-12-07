package net.woolgens.scaffold.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@Provider
public class LandExceptionMapper implements ExceptionMapper<LandException> {

    @Override
    public Response toResponse(LandException exception) {
        return Response.status(exception.getStatus()).entity(new LandExceptionResponse(exception.getStatus(), exception.getMessage())).build();
    }
}

package net.woolgens.scaffold.resource;

import net.woolgens.scaffold.exception.LandException;
import net.woolgens.scaffold.exception.impl.LandNotFoundException;
import net.woolgens.scaffold.model.Land;
import net.woolgens.scaffold.repository.LandRepository;
import net.woolgens.scaffold.service.LandService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/lands")
public class LandResource {

    @Inject
    LandRepository repository;

    @Inject
    LandService service;

    @GET
    public Response getAll(@QueryParam("small") String small) {
        if(small != null) {
            return Response.ok(service.getAllSmallProjectedLands()).build();
        }
        return Response.ok(repository.listAll()).build();
    }

    @GET
    @Path("/{id}")
    public Land get(@PathParam("id") String id) throws LandException {
        Optional<Land> landOptional = repository.findByIdOptional(id);
        if(!landOptional.isPresent()) {
            throw new LandNotFoundException();
        }
        return landOptional.get();
    }

    @PUT
    @RolesAllowed("Admin")
    public Land put(Land land)  {
        repository.persistOrUpdate(land);
        return land;
    }

    @DELETE
    @RolesAllowed("Admin")
    @Path("/{id}")
    public boolean delete(@PathParam("id") String id)  {
        return repository.deleteById(id);
    }

}
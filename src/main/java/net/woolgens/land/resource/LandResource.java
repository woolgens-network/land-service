package net.woolgens.land.resource;

import net.woolgens.land.model.Land;
import net.woolgens.land.repository.LandRepository;
import net.woolgens.land.service.LandService;
import net.woolgens.library.microservice.exception.ServiceException;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/lands")
public class LandResource {

    @Inject
    LandRepository repository;

    @Inject
    LandService service;

    @GET
    public Response getAll(@QueryParam("sorted") String sorted,
                           @QueryParam("pageindex") String pageIndex,
                           @QueryParam("pagesize") String pageSize,
                           @QueryParam("small") String small) {
        if(small != null) {
            return Response.ok(service.getAllSmallProjectedLands()).build();
        }
        if(sorted != null) {
            return Response.ok(service.getAllSortedAndPaged(sorted, pageIndex, pageSize)).build();
        }
        return Response.ok(repository.listAll()).build();
    }

    @GET
    @Path("/{id}")
    public Land get(@PathParam("id") String id) throws ServiceException {
        Optional<Land> landOptional = repository.findByIdOptional(id);
        if(!landOptional.isPresent()) {
            throw new ServiceException(404, "Land not found");
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
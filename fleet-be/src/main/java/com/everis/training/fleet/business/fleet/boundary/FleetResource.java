package com.everis.training.fleet.business.fleet.boundary;

import com.everis.training.fleet.business.fleet.control.FleetController;
import com.everis.training.fleet.business.fleet.entity.Fleet;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1/fleets")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Stateless
public class FleetResource {
    @Inject
    FleetController controller;

    @GET
    public Response retrieveAllVehicles() {
        return Response.ok().entity(controller.retrieveAllFleets()).build();
    }

    @POST
    public Response createFleet(Fleet fleet) {
        controller.createFleet(fleet);
        return Response.ok().entity("Fleet created.").build();
    }
    @Path("{fleetId}")
    @GET
    public Response retrieveFleet(@PathParam("fleetId") final Integer id) {
        return Response.ok().entity(controller.retrieveFleet(id)).build();
    }

    @Path("{fleetId}")
    @POST
    public Response updateFleet(Fleet fleet) {
        controller.updateFleet(fleet);
        return Response.ok().entity("Fleet updated.").build();
    }

    @Path("{fleetId}")
    @DELETE
    public Response deleteFleet(@PathParam("fleetId") final Integer id) {
        controller.deleteFleet(id);
        return Response.ok().entity("Fleet removed.").build();
    }
}

package com.everis.training.fleet.business.fleet.boundary;

import com.everis.training.fleet.business.fleet.control.FleetController;
import com.everis.training.fleet.business.fleet.entity.Fleet;
import com.google.gson.Gson;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

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

    @POST
    public Response createFleet(@RequestBody String json) {
        Gson gson = new Gson();
        Fleet fleet = gson.fromJson(json, Fleet.class);
        controller.createFleet(fleet);
        return Response.ok().entity(fleet.toString()).build();
    }
    @Path("{fleetId}")
    @GET
    public Response retrieveFleet(@PathParam("fleetId") int id) {
        Fleet f = controller.retrieveFleet(id);
        Gson gson = new Gson();
        return Response.ok().entity(gson.toJson(f)).build();
    }

    @PUT
    public Response updateFleet(@RequestBody String json) {
        Gson gson = new Gson();
        Fleet f = gson.fromJson(json, Fleet.class);
        controller.updateFleet(f);
        return Response.ok().entity("Fleet updated.").build();
    }

    @Path("{fleetId}")
    @DELETE
    public Response deleteFleet(@PathParam("fleetId") final int id) {
        controller.deleteFleet(id);
        return Response.ok().entity("Fleet removed.").build();
    }
}

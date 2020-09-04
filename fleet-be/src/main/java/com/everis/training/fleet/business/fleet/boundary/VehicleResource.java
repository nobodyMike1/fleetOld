package com.everis.training.fleet.business.fleet.boundary;


import com.everis.training.fleet.business.fleet.control.VehicleController;
import com.everis.training.fleet.business.fleet.entity.Vehicle;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1/vehicles")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@Stateless
public class VehicleResource {

  @Inject
  VehicleController controller;

  @GET
  public Response retrieveAllVehicles() {
    return Response.ok().entity(controller.retrieveAllVehicles()).build();
  }

  @POST
  public Response createVehicle(Vehicle vehicle) {
    controller.createVehicle(vehicle);
    return Response.ok().entity("Vehicle created.").build();
  }

  @Path("{vehicleId}")
  @GET
  public Response retrieveVehicle(@PathParam("vehicleId") final Integer id) {
    return Response.ok().entity(controller.retrieveVehicle(id)).build();
  }

  @Path("{vehicleId}")
  @POST
  public Response updateVehicle(Vehicle vehicle) {
    controller.updateVehicle(vehicle);
    return Response.ok().entity("Vehicle updated.").build();
  }

  @Path("{vehicleId}")
  @DELETE
  public Response deleteVehicle(@PathParam("vehicleId") Integer id) {
    controller.deleteVehicle(id);
    return Response.ok().entity("Vehicle " + id + " removed from the database.").build();
  }

  @Path("search")
  @GET
  public Response searchByVin(@QueryParam("vin") final String vin ) {
    return Response.ok().entity(controller.searchByVin(vin)).build();
  }

  @Path("unreserved")
  @GET
  public Response searchUnreservedVehicles() {
    return Response.ok().entity(controller.searchUnreservedVehicles()).build();
  }
}

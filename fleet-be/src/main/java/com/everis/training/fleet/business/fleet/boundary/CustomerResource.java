package com.everis.training.fleet.business.fleet.boundary;

import com.everis.training.fleet.business.fleet.control.CustomerController;
import com.everis.training.fleet.business.fleet.entity.Customer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class CustomerResource {
    @Inject
    CustomerController controller;

    @POST
    public Response createCustomer(Customer customer) {
        controller.createCustomer(customer);
        return Response.ok().entity("Customer created.").build();
    }

    @Path("{customerId}")
    @GET
    public Response retrieveCustomer(@PathParam("customerId") final Integer id) {
        return Response.ok().entity(controller.retrieveCustomer(id)).build();
    }

    @PUT
    public Response updateCustomer(Customer customer) {
        controller.updateCustomer(customer);
        return Response.ok().entity("Customer updated.").build();
    }

    @Path("{customerId}")
    @DELETE
    public Response deleteCustomer(@PathParam("customerId") final Integer id) {
        controller.deleteCustomer(id);
        return Response.ok().entity("Customer " + id + " deleted.").build();
    }

    @Path("reserveVehicle/{customerId}/{vehicleVin}")
    @GET
    public Response reserveVehicle(@PathParam("customerId") Integer id, @PathParam("vehicleVin") String vin) {
        controller.reserveVehicle(id, vin);
        return Response.ok().entity("Vehicle reserved.").build();
    }

    @Path("finalizeVehicleReservation/{customerId}")
    @GET
    public Response finalizeVehicleReservation(@PathParam("customerId") Integer id) {
        controller.finalizeVehicleReservation(id);
        return Response.ok().entity("Vehicle reservation finalized.").build();
    }
}

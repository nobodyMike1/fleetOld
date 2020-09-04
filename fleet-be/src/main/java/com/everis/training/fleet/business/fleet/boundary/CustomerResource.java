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

    @GET
    public Response retrieveAllCustomers() {
        return Response.ok().entity(controller.retrieveAllCustomers()).build();
    }

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

    @Path("{customerId}")
    @POST
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

    @Path("reserve")
    @GET
    public Response reserveVehicle(@QueryParam("customerId") Integer id, @QueryParam("vehicleVin") String vin) {
        controller.reserveVehicle(id, vin);
        return Response.ok().entity(id + " " + vin).build();
    }

    @Path("finalize-reservation")
    @GET
    public Response finalizeVehicleReservation(@QueryParam("customerId") Integer id) {
        controller.finalizeVehicleReservation(id);
        return Response.ok().entity("Vehicle reservation finalized.").build();
    }
}

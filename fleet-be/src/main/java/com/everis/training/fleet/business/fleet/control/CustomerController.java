package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CustomerController {
    @Inject
    CustomerRepository repository;

    public List<Customer> retrieveAllCustomers() {
        return repository.retrieveAll();
    }

    public void createCustomer(Customer customer) {
        repository.create(customer);
    }

    public Customer retrieveCustomer(Integer id) {
        return repository.retrieve(id);
    }

    public void updateCustomer(Customer customer) {
        repository.update(customer);
    }

    public void deleteCustomer(Integer id) {
        repository.delete(id);
    }

    public void reserveVehicle(Integer id, String vin) {
        repository.reserveVehicle(id, vin);
    }

    public void finalizeVehicleReservation(Integer id) {
        repository.finalizeVehicleReservation(id);
    }
}

package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Vehicle;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class VehicleController {

    @Inject
    VehicleRepository repository;

    public void createVehicle(Vehicle vehicle) {
        repository.create(vehicle);
    }

    public Vehicle retrieveVehicle(Integer id) {
        return repository.retrieve(id);
    }

    public void updateVehicle(Vehicle vehicle) {
        repository.update(vehicle);
    }

    public void deleteVehicle(Integer id) {
        repository.delete(id);
    }

    public Vehicle searchByVin(String vin) {
        return repository.retrieveByVin(vin);
    }

    public List<Vehicle> searchUnreservedVehicles() {
        return repository.searchUnreserved();
    }
}

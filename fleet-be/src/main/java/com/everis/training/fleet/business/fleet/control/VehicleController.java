package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Vehicle;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class VehicleController {

    @Inject
    VehicleRepository repo;

    public List<Vehicle> getAllVehicles() {
        return repo.getAll();
    }

    public String register(Vehicle v) {
        if (v.getVin().length()==17) {
            repo.registerVehicle(v);
            return "Vehicle successfully registered.";
        } else {
            return "Vin must contain 17 alphanumeric characters. Unable to Register Vehicle.";
        }
    }

    public void delete(String vin) {
        repo.deleteVehicle(vin);
    }

    public Vehicle retrieve(String vin) {
        if (vin.length() == 17) {
            return repo.retrieveVehicle(vin);
        } else {
            return null;
        }
    }

}

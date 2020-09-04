package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Vehicle;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import java.util.List;

@ApplicationScoped
public class VehicleRepository {
    @PersistenceContext(unitName = "fleet")
    EntityManager entityManager;

    public List<Vehicle> retrieveAll() {
        return entityManager.createNamedQuery("allVehicles").getResultList();
    }

    public void create(Vehicle vehicle) {
        entityManager.persist(vehicle);
    }

    public Vehicle retrieve(Integer id) {
        return entityManager.find(Vehicle.class, id);
    }

    public void update(Vehicle vehicle) {
        entityManager.merge(vehicle);
    }

    public void delete(Integer id) {
        entityManager.remove(entityManager.find(Vehicle.class, id));
    }

    public Vehicle searchByVin(String vin) {
         List<Vehicle> listVehicles = entityManager.createNamedQuery("vehicleByVin", Vehicle.class)
                .setParameter("vin", vin)
                .getResultList();
         if (!listVehicles.isEmpty()) return listVehicles.get(0);
         else return null;
    }

    public List<Vehicle> searchUnreserved() {
        return entityManager.createNamedQuery("unreservedVehicles").getResultList();
    }

}

package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Vehicle;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class VehicleRepository {
    @PersistenceContext(unitName = "fleet")
    EntityManager entityManager;

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
        Query query = entityManager.createNativeQuery("select * from vehicles where vin=?1", Vehicle.class);
        query.setParameter(1, vin);
        List<Vehicle> vehicle = query.getResultList();
        return vehicle.get(0);
    }

    public List<Vehicle> searchUnreserved() {
        Query query = entityManager.createNativeQuery("select * from vehicles where vin not in " +
                "( select vehicle from customers where vehicle is not null);\n", Vehicle.class);
        return query.getResultList();
    }
}

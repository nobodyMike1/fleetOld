package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Fleet;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class FleetRepository {
    @PersistenceContext(unitName = "fleet")
    EntityManager entityManager;

    public List<Fleet> retrieveAll() {
        return entityManager.createNamedQuery("allFleets").getResultList();
    }

    public void create(Fleet fleet) {
        entityManager.persist(fleet);
    }

    public Fleet retrieve(Integer id) {
        return entityManager.find(Fleet.class, id);
    }

    public void update(Fleet fleet) {
        entityManager.merge(fleet);
    }

    public void delete(int id) {
        entityManager.remove(entityManager.find(Fleet.class, id));
    }
}

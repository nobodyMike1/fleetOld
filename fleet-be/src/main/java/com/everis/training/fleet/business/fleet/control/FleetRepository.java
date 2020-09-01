package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Fleet;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class FleetRepository {
    @PersistenceContext(unitName = "fleet")
    EntityManager em;

    public void create(Fleet fleet) {
        em.persist(fleet);
    }


    public Fleet retrieve(Integer id) {
        return em.find(Fleet.class, id);
    }

    public void update(Fleet fleet) {
        em.merge(fleet);
    }

    public void delete(int id) {
        em.remove(em.find(Fleet.class, id));
    }
}

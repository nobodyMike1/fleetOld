package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Fleet;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FleetController {
    @Inject
    FleetRepository repository;

    public void createFleet(Fleet fleet) {
        repository.create(fleet);
    }

    public Fleet retrieveFleet(Integer id) {
        return repository.retrieve(id);
    }

    public void updateFleet(Fleet fleet) {
        repository.update(fleet);
    }

    public void deleteFleet(int id) {
        repository.delete(id);
    }
}

package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Fleet;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class FleetController {
    @Inject
    FleetRepository repository;

    public List<Fleet> retrieveAllFleets() {
        return repository.retrieveAll();
    }

    public void createFleet(Fleet fleet) {
        repository.create(fleet);
    }

    public Fleet retrieveFleet(Integer id) {
        return repository.retrieve(id);
    }

    public void updateFleet(Fleet fleet) {
        repository.update(fleet);
    }

    public void deleteFleet(Integer id) {
        repository.delete(id);
    }
}

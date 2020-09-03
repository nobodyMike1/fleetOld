package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class CustomerRepository {
    @PersistenceContext(unitName = "fleet")
    EntityManager entityManager;

    public List<Customer> retrieveAll() {
        return entityManager.createNamedQuery("allCustomers").getResultList();
    }

    public void create(Customer customer) {
        entityManager.persist(customer);
    }

    public Customer retrieve(Integer id) {
        return entityManager.find(Customer.class, id);
    }

    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    public void delete(Integer id) {
        entityManager.remove(entityManager.find(Customer.class, id));
    }

    public void reserveVehicle(Integer id, String vin) {
        Customer customer = entityManager.find(Customer.class, id);
        customer.setVehicle(vin);
        entityManager.merge(customer);
    }

    public void finalizeVehicleReservation(Integer id) {
        Customer customer = entityManager.find(Customer.class, id);
        customer.setVehicle(null);
        entityManager.merge(customer);
    }
}

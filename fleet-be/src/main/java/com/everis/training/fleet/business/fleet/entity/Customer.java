package com.everis.training.fleet.business.fleet.entity;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "allCustomers",
                query = "select c from Customer c")
})
@Table(name = "customers", schema = "public")
public class Customer {
    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private String vehicle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
}

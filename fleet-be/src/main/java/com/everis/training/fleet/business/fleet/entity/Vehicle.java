package com.everis.training.fleet.business.fleet.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "allVehicles",
                query = "select v from Vehicle v"),
        @NamedQuery(name = "vehicleByVin",
                query="select v from Vehicle v where v.vin=:vin"),
        @NamedQuery(name = "unreservedVehicles",
                query="select v from Vehicle v where not exists (" +
                        "select c from Customer c where c.vehicle = v.vin)")
})
@Table(name = "vehicles", schema = "public")
public class Vehicle implements Serializable {
    @Id
    private Integer id;

    @Column
    private String vin;

    @Column
    private String registration;

    @Column
    private Integer fleet;

    // Gets and Sets

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public int getFleet() {
        return fleet;
    }

    public void setFleet(int fleet) {
        this.fleet = fleet;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", registration='" + registration + '\'' +
                ", fleet=" + fleet + "}";
    }
}
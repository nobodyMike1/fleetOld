package com.everis.training.fleet.business.fleet.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicles")
public class Vehicle implements Serializable {
    @Id
    private String vin;

    @Column(name = "registration")
    private String registration;

    @Column(name = "fleet")
    private int fleet;

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
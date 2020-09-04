package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Vehicle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class VehicleControllerTest {

    @InjectMocks
    VehicleController underTest;
    @Mock
    VehicleRepository repositoryMock;

    @Test
    void createVehicle() {
        //given
        Vehicle vehicle = new Vehicle();
        vehicle.setVin("123456789abcdebhu");
        vehicle.setId(10);
        vehicle.setFleetId(1);
        vehicle.setRegistration("avcde");
        //when
        underTest.createVehicle(vehicle);
        //then
        verify(repositoryMock).create(vehicle);
    }

    @Test
    void retrieveVehicle() {
        //given
        //when
        underTest.retrieveVehicle(1);
        //then
        verify(repositoryMock).retrieve(1);
    }

    @Test
    void updateVehicle() {
        //given
        Vehicle vehicle = new Vehicle();
        vehicle.setVin("123456789murcia12");
        vehicle.setId(1);
        vehicle.setFleetId(1);
        vehicle.setRegistration("avcde");
        //when
        underTest.updateVehicle(vehicle);
        //then
        verify(repositoryMock).update(vehicle);
    }

    @Test
    void deleteVehicle() {
        //given
        Integer id = 1;
        //when
        underTest.deleteVehicle(1);
        //then
        verify(repositoryMock).delete(1);
    }

    @Test
    void searchByVin() {
        //given
        String vin = "123456789asdfghjk";
        //when
        underTest.searchByVin(vin);
        //then
        verify(repositoryMock).searchByVin(vin);
    }

    @Test
    void searchUnreservedVehicles() {
        //given
        //when
        underTest.searchUnreservedVehicles();
        //then
        verify(repositoryMock).searchUnreserved();
    }
}
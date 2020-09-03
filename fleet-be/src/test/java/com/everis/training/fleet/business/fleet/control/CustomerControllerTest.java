package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.inject.Inject;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @InjectMocks
    private CustomerController underTest;
    @Mock
    private CustomerRepository repositoryMock;


    @Test
    public void createCustomer() {
        //given
        Customer customer = new Customer();
        customer.setVehicle("abcde");
        customer.setId(1);
        customer.setName("vehiculo prueba");
        //when
        underTest.createCustomer(customer);
        //then
        verify(repositoryMock).create(customer);
    }

    @Test
    public void retrieveCustomer() {
        //given
        Integer id = 1;
        //when
        underTest.retrieveCustomer(id);
        //then
        verify(repositoryMock).retrieve(id);
    }

    @Test
    public void updateVehicle() {
        //given
        Customer customer = new Customer();
        customer.setVehicle("abcde");
        customer.setId(1);
        customer.setName("vehiculo prueba");
        //when
        underTest.updateCustomer(customer);
        //then
        verify(repositoryMock).update(customer);
    }

    @Test
    public void deleteVehicle() {
        //given
        Integer id = 1;
        //when
        underTest.deleteCustomer(id);
        //then
        verify(repositoryMock).delete(id);
    }

    @Test
    public void reserveVehicle() {
        // given
        String vin = "vinPrueba";
        Integer id = 1;
        // when
        underTest.reserveVehicle(id, vin);
        // then
        verify(repositoryMock).reserveVehicle(id, vin);
    }

    @Test
    public void finalizeVehicleReservation() {
        // given
        Integer id = 1;
        // when
        underTest.finalizeVehicleReservation(id);
        // then
        verify(repositoryMock).finalizeVehicleReservation(id);
    }

}
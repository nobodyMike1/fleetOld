package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Fleet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FleetControllerTest {

    @InjectMocks
    private FleetController underTest;

    @Mock
    private FleetRepository repositoryMock;

    @Test
    public void createFleet() {
        // given
        Fleet fleet = new Fleet();
        fleet.setId(1);
        fleet.setName("FleetPrueba");
        // when
        underTest.createFleet(fleet);
        // then
        verify(repositoryMock).create(fleet);
    }

    @Test
    public void retrieveFleet() {
        // given
        Integer id = 1;
        // when
        underTest.retrieveFleet(id);
        // then
        verify(repositoryMock).retrieve(id);
    }

    @Test
    public void updateFleet() {
        // given
        Fleet fleet = new Fleet();
        fleet.setId(1);
        fleet.setName("FleetPrueba");
        // when
        underTest.updateFleet(fleet);
        // then
        verify(repositoryMock).update(fleet);
    }

    @Test
    public void deleteFleet() {
        // given
        int id = 1;
        // when
        underTest.deleteFleet(id);
        // then
        verify(repositoryMock).delete(id);
    }
}
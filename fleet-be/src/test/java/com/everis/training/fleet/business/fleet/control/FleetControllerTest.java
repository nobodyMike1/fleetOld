package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Fleet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FleetControllerTest {

    @InjectMocks
    FleetController underTest;

    @Mock
    FleetRepository repositoryMock;

    @Test
    void createFleet() {
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
    void retrieveFleet() {
        // given
        Integer id = 1;
        // when
        underTest.retrieveFleet(id);
        // then
        verify(repositoryMock).retrieve(id);
    }

    @Test
    void updateFleet() {
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
    void deleteFleet() {
        // given
        int id = 1;
        // when
        underTest.deleteFleet(id);
        // then
        verify(repositoryMock).delete(id);
    }
}
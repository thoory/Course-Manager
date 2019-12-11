package fr.utbm.lo54.tp.scheduler.service;

import fr.utbm.lo54.tp.scheduler.entity.CourseEntity;
import fr.utbm.lo54.tp.scheduler.entity.LocationEntity;
import fr.utbm.lo54.tp.scheduler.repository.CourseDAO;
import fr.utbm.lo54.tp.scheduler.repository.LocationDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class LocationServiceTest {

    @Mock
    private LocationDAO locationDaoMock;

    @InjectMocks
    private LocationService locationService;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        LocationEntity locationEntity1 = new LocationEntity();
        locationEntity1.setId(1);
        locationEntity1.setCity("Belfort");

        LocationEntity locationEntity2 = new LocationEntity();
        locationEntity2.setId(2);
        locationEntity2.setCity("Sevenans");

        when(locationDaoMock.getAll()).thenReturn(List.of(locationEntity1, locationEntity2));
        when(locationDaoMock.get(1)).thenReturn(locationEntity1);
    }

    @Test
    public void getAll() {
        List<LocationEntity> allLocations = locationDaoMock.getAll();
        assertNotNull(allLocations);
        assertEquals(2, allLocations.size());

        assertEquals(1, allLocations.get(0).getId() );
        assertEquals("Belfort", allLocations.get(0).getCity());

        assertEquals(2, allLocations.get(1).getId());
        assertEquals("Sevenans", allLocations.get(1).getCity());
    }

    @Test
    public void getById() {
        LocationEntity locationEntity = locationDaoMock.get(1);
        assertEquals(1, locationEntity.getId());
        assertEquals("Belfort", locationEntity.getCity());
    }
}
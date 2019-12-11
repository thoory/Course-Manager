package fr.utbm.lo54.tp.scheduler.service;

import fr.utbm.lo54.tp.scheduler.entity.ClientEntity;
import fr.utbm.lo54.tp.scheduler.entity.CourseEntity;
import fr.utbm.lo54.tp.scheduler.entity.CourseSessionEntity;
import fr.utbm.lo54.tp.scheduler.entity.LocationEntity;
import fr.utbm.lo54.tp.scheduler.repository.ClientDAO;
import fr.utbm.lo54.tp.scheduler.repository.CourseSessionDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class CourseSessionServiceTest {

    @Mock
    private CourseSessionDAO courseSessionDaoMock;

    @InjectMocks
    private CourseSessionService courseSessionService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        ClientEntity john = new ClientEntity();
        john.setId(1);
        john.setFirstname("John");
        john.setLastname("Doe");

        ClientEntity jack = new ClientEntity();
        jack.setId(2);
        jack.setFirstname("Jack");
        jack.setLastname("L'éventreur");

        LocationEntity belfort = new LocationEntity();
        belfort.setId(1);
        belfort.setCity("Belfort");

        LocationEntity sevenans = new LocationEntity();
        sevenans.setId(2);
        sevenans.setCity("Sevenans");

        CourseEntity maths = new CourseEntity();
        maths.setCode("MAT");
        maths.setTitle("Maths");

        CourseEntity anglais = new CourseEntity();
        anglais.setCode("ENG");
        anglais.setTitle("English");

        CourseSessionEntity courseSessionEntity1 = new CourseSessionEntity();
        courseSessionEntity1.setId(1);
        courseSessionEntity1.setClientList(List.of(john, jack));
        courseSessionEntity1.setCourse(maths);
        courseSessionEntity1.setLocation(belfort);
        courseSessionEntity1.setMax(50);

        CourseSessionEntity courseSessionEntity2 = new CourseSessionEntity();
        courseSessionEntity2.setId(2);
        courseSessionEntity2.setClientList(List.of(john, jack));
        courseSessionEntity2.setCourse(anglais);
        courseSessionEntity2.setLocation(sevenans);
        courseSessionEntity2.setMax(35);


        when(courseSessionDaoMock.getAll()).thenReturn(List.of(courseSessionEntity1, courseSessionEntity2));
        when(courseSessionDaoMock.getById(1)).thenReturn(courseSessionEntity1);
        when(courseSessionDaoMock.getByLocation(1)).thenReturn(List.of(courseSessionEntity1));
        when(courseSessionDaoMock.searchCourse("Maths")).thenReturn(List.of(courseSessionEntity1.getCourse().getTitle()));

    }

    @Test
    public void getAll() {
        List<CourseSessionEntity> courseSessionEntities = courseSessionDaoMock.getAll();

        verify(courseSessionDaoMock, times(1)).getAll();
        assertNotNull(courseSessionEntities);

        assertEquals(1, courseSessionEntities.get(0).getId());
        assertEquals("Belfort", courseSessionEntities.get(0).getLocation().getCity());
        assertEquals(1, courseSessionEntities.get(0).getLocation().getId());

        assertEquals(2, courseSessionEntities.get(1).getId());
        assertEquals("Sevenans", courseSessionEntities.get(1).getLocation().getCity());
        assertEquals(2, courseSessionEntities.get(1).getLocation().getId());

    }

    @Test
    public void getById() {
        CourseSessionEntity courseSessionEntity = courseSessionDaoMock.getById(1);

        verify(courseSessionDaoMock, times(1)).getById(1);

        assertEquals(1, courseSessionEntity.getId());
        assertEquals("Belfort", courseSessionEntity.getLocation());
    }

    @Test
    public void getByLocation() {
        List<CourseSessionEntity> courseSessionEntities = courseSessionDaoMock.getByLocation(1);

        verify(courseSessionDaoMock, times(1)).getByLocation(1);

        assertEquals(1, courseSessionEntities.get(0).getId());
        assertEquals("MAT", courseSessionEntities.get(0).getCourse().getCode());
        assertEquals("Maths", courseSessionEntities.get(0).getCourse().getTitle());
        assertEquals("Belfort", courseSessionEntities.get(0).getLocation().getCity());
        assertEquals(1, courseSessionEntities.get(0).getLocation().getId());
    }

    @Test
    public void searchCourse() {
    }

    @Test
    public void getByDate() {
    }
}
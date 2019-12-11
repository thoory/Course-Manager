package fr.utbm.lo54.tp.scheduler.service;

import fr.utbm.lo54.tp.scheduler.entity.CourseEntity;
import fr.utbm.lo54.tp.scheduler.repository.ClientDAO;
import fr.utbm.lo54.tp.scheduler.repository.CourseDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

public class CoursesServiceTest {

    @Mock
    private CourseDAO courseDaoMock;

    @InjectMocks
    private CoursesService coursesService;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        CourseEntity course1 = new CourseEntity();
        course1.setCode("PHY");
        course1.setTitle("Physique");

        CourseEntity course2 = new CourseEntity();
        course2.setCode("CHI");
        course2.setTitle("Chimie");

        when(courseDaoMock.getAll()).thenReturn(List.of(course1, course2));
    }

    @Test
    public void getAll() {
        List<CourseEntity> allCourses = courseDaoMock.getAll();

        verify(courseDaoMock, times(1)).getAll();

        assertNotNull(allCourses);
        assertEquals(2, allCourses.size());

        assertEquals("PHY", allCourses.get(0).getCode());
        assertEquals("Physique", allCourses.get(0).getTitle());

        assertEquals("CHI", allCourses.get(1).getCode());
        assertEquals("Chimie", allCourses.get(1).getTitle());
    }

    @Test
    public void save() {
    }
}
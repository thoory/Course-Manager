package fr.utbm.lo54.tp.scheduler.service;

import fr.utbm.lo54.tp.scheduler.entity.CourseEntity;
import fr.utbm.lo54.tp.scheduler.repository.CourseDAO;

import java.util.List;

public class CoursesService {
    public List<CourseEntity> getAll() {
        List<CourseEntity> courses;
        CourseDAO cDAO = new CourseDAO();
        courses = cDAO.getAll();
        return courses;
    }

    public void save(CourseEntity course) {
        CourseDAO cDAO = new CourseDAO();
        cDAO.update(course);
    }
}

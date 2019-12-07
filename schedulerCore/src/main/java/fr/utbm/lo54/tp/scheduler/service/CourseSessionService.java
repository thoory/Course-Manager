package fr.utbm.lo54.tp.scheduler.service;

import fr.utbm.lo54.tp.scheduler.entity.CourseSessionEntity;
import fr.utbm.lo54.tp.scheduler.repository.CourseSessionDAO;

import java.util.List;

public class CourseSessionService {
    public List<CourseSessionEntity> getAll() {
        List<CourseSessionEntity> session;
        CourseSessionDAO cDAO = new CourseSessionDAO();

        session = cDAO.getAll();
        return session;
    }

    public CourseSessionEntity getById(int id) {
        CourseSessionEntity session;
        CourseSessionDAO cDAO = new CourseSessionDAO();

        session = cDAO.getById(id);
        return session;
    }

    public List<CourseSessionEntity> getByLocation(int id) {
        List<CourseSessionEntity> session;
        CourseSessionDAO cDAO = new CourseSessionDAO();

        session = cDAO.getByLocation(id);
        return session;
    }

    public List<CourseSessionEntity> searchCourse(String request) {
        List<CourseSessionEntity> session;
        CourseSessionDAO cDAO = new CourseSessionDAO();

        session = cDAO.searchCourse(request);
        return session;
    }

    public List<CourseSessionEntity> getByDate(String date) {
        List<CourseSessionEntity> session;
        CourseSessionDAO cDAO = new CourseSessionDAO();

        session = cDAO.getByDate(date);
        return session;
    }
}

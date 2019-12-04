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

    public List<CourseSessionEntity> getByCode(int id) {
        List<CourseSessionEntity> session;
        CourseSessionDAO cDAO = new CourseSessionDAO();

        session = cDAO.getByCourseCode(id);
        return session;
    }

    public void update(CourseSessionEntity courseSession) {
        CourseSessionDAO cDAO = new CourseSessionDAO();
        cDAO.save(courseSession);
    }

    public void save(CourseSessionEntity courseSession) {
        CourseSessionDAO cDAO = new CourseSessionDAO();
        cDAO.update(courseSession);
    }

    public void delete(CourseSessionEntity courseSession) {
        CourseSessionDAO cDAO = new CourseSessionDAO();
        cDAO.delete(courseSession);
    }
}

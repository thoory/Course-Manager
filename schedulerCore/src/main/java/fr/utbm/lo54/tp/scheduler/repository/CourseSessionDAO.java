package fr.utbm.lo54.tp.scheduler.repository;

import fr.utbm.lo54.tp.scheduler.entity.CourseSessionEntity;
import fr.utbm.lo54.tp.scheduler.entity.CourseSessionEntity;
import fr.utbm.lo54.tp.scheduler.tools.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class CourseSessionDAO {

    public List<CourseSessionEntity> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query queryResult = session.createQuery("from CourseSessionEntity ");
        return queryResult.list();
    }

    public CourseSessionEntity getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CourseSessionEntity courseSession = session.get(CourseSessionEntity.class, id);
        return courseSession;
    }

    public List<CourseSessionEntity> getByCourseCode(int courseCode) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<CourseSessionEntity> courseSessions =  (List<CourseSessionEntity>) session.get(CourseSessionEntity.class, courseCode);
        return courseSessions;
    }

    public List<CourseSessionEntity> getByLocation(int locId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<CourseSessionEntity> sessions = null;
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            String hql = "FROM CourseSessionEntity where location_id = " + locId;
            Query query = session.createQuery(hql);
            sessions = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return sessions;
    }

    public void update(CourseSessionEntity courseSession) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(courseSession);
        transaction.commit();
        session.close();
    }

    public void save(CourseSessionEntity courseSession) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(courseSession);
        transaction.commit();
        session.close();
    }

    public void delete(CourseSessionEntity courseSession) {
        HibernateUtil.getSessionFactory().openSession().delete(courseSession);
    }
}

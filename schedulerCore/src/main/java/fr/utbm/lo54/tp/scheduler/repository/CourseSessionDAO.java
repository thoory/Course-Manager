package fr.utbm.lo54.tp.scheduler.repository;

import fr.utbm.lo54.tp.scheduler.entity.CourseSessionEntity;
import fr.utbm.lo54.tp.scheduler.tools.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public List searchCourse(String request) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM CourseSessionEntity WHERE course.title LIKE :p1");
        query.setParameter("p1", "%"+request+"%");
        List CourseSessions = query.list();

        return CourseSessions;
    }

    public List<CourseSessionEntity> getByLocation(int locId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM CourseSessionEntity WHERE location.id = :l1");
        query.setParameter("l1", locId);
        List<CourseSessionEntity> CourseSessions = query.list();
        return CourseSessions;
    }

    public List<CourseSessionEntity> getByDate(String date) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            c.setTime(dateFormat.parse(date));
        }catch(ParseException e){
            e.printStackTrace();
        }

        Query query = session.createQuery("FROM CourseSessionEntity WHERE startDate BETWEEN :d1 AND :d2");
        query.setParameter("d1", c.getTime());
        c.add(Calendar.DATE, 1);
        query.setParameter("d2", c.getTime());

        List courseSessions = query.list();

        return courseSessions;
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

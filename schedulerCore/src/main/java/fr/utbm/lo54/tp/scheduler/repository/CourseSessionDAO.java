package fr.utbm.lo54.tp.scheduler.repository;

import fr.utbm.lo54.tp.scheduler.entity.CourseEntity;
import fr.utbm.lo54.tp.scheduler.entity.CourseSessionEntity;
import fr.utbm.lo54.tp.scheduler.entity.CourseSessionEntity;
import fr.utbm.lo54.tp.scheduler.tools.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public List<CourseSessionEntity> getWithFilter(String search, String date, int locationId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<CourseSessionEntity> sessions = null;
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<CourseSessionEntity> query = builder.createQuery(CourseSessionEntity.class);
            Root<CourseSessionEntity> root = query.from(CourseSessionEntity.class);

            query.select(root);
            //query.where(builder.equal(root.get("location_id"), locationId));
            //query.where(builder.between(root.get("startDate"), "2019-09-04", "2019-09-05"));
            //if (search != null) {
            //    Join<CourseSessionEntity, CourseEntity> book = root.join(CourseSessionEntity_.course_code);
            //}

            Query<CourseSessionEntity> q = session.createQuery(query);
            sessions = q.getResultList();
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

    public List searchCourse(String request) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM CourseSessionEntity WHERE course_code.title LIKE :p1");
        query.setParameter("p1", "%"+request+"%");
        List CourseSessions = query.list();

        return CourseSessions;
    }

    public List<CourseSessionEntity> getByLocation(int locId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<CourseSessionEntity> sessions = null;
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            String hql = "FROM CourseSessionEntity where location_id="+locId;
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

        List CourseSessions = query.list();

        return CourseSessions;
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

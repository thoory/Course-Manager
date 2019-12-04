package fr.utbm.lo54.tp.scheduler.repository;

import fr.utbm.lo54.tp.scheduler.entity.CourseEntity;
import fr.utbm.lo54.tp.scheduler.tools.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDAO {

    public List<CourseEntity> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query queryResult = session.createQuery("from CourseEntity ");
        return queryResult.list();
    }

    public CourseEntity getByCode(String code) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CourseEntity course =  (CourseEntity) session.get(CourseEntity.class, code);
        return course;
    }

    public void update(CourseEntity course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(course);
        transaction.commit();
        session.close();
    }

    public void save(CourseEntity course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(course);
        transaction.commit();
        session.close();
    }

    public void deleteByCode(String code) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CourseEntity c = (CourseEntity)session.load(CourseEntity.class,code);
        Transaction transaction = session.beginTransaction();
        session.delete(c);
        transaction.commit();
        session.close();
    }
}

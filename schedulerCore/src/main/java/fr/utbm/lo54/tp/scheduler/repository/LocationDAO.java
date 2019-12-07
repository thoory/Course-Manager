package fr.utbm.lo54.tp.scheduler.repository;

import fr.utbm.lo54.tp.scheduler.entity.LocationEntity;
import fr.utbm.lo54.tp.scheduler.tools.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LocationDAO {

    public List<LocationEntity> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query queryResult = session.createQuery("from LocationEntity ");
        return queryResult.list();
    }

    public LocationEntity get(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        LocationEntity locations =  (LocationEntity) session.get(LocationEntity.class, id);
        return locations;
    }

    public void update(LocationEntity location) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(location);
        transaction.commit();
        session.close();
    }

    public void save(LocationEntity location) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(location);
        transaction.commit();
        session.close();
    }

    public void deleteById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        LocationEntity l = (LocationEntity)session.load(LocationEntity.class,id);
        Transaction transaction = session.beginTransaction();
        session.delete(l);
        transaction.commit();
        session.close();
    }
}

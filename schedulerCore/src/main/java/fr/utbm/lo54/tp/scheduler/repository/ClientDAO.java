package fr.utbm.lo54.tp.scheduler.repository;

import fr.utbm.lo54.tp.scheduler.entity.ClientEntity;
import fr.utbm.lo54.tp.scheduler.tools.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class ClientDAO {

    public List<ClientEntity> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query queryResult = session.createQuery("from ClientEntity ");
        return queryResult.list();
    }

    public ClientEntity get(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ClientEntity client =  (ClientEntity) session.get(ClientEntity.class, id);
        return client;
    }

    public void update(ClientEntity client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(client);
        transaction.commit();
        session.close();
    }

    public void save(ClientEntity client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ClientEntity l = (ClientEntity)session.load(ClientEntity.class, id);
        Transaction transaction = session.beginTransaction();
        session.delete(l);
        transaction.commit();
        session.close();
    }
}
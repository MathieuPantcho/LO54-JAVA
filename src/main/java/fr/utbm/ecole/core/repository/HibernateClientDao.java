package fr.utbm.ecole.core.repository;

import fr.utbm.ecole.core.entity.Client;
import fr.utbm.ecole.core.tools.HibernateUtil;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HibernateClientDao {

    Transaction transaction = null;

    public void save(Client c) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(c);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public ArrayList<Client> listFilm() {
        ArrayList<Client> films = new ArrayList<Client>();
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery("from CLIENT");
        films = (ArrayList<Client>) q.list();
        return films;
    }

    public Client getClientById(Integer clientId) {
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("video");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(Client.class, 1L);
        
    }

    public void update(Client c) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(c);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}

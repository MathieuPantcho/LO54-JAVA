package fr.utbm.ecole.core.repository;

import fr.utbm.ecole.core.entity.Location;
import fr.utbm.ecole.core.tools.HibernateUtil;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HibernateLocationDao {

    Transaction transaction = null;

    public void save(Location l) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(l);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public ArrayList<Location> listLocation() {
        ArrayList<Location> locations = new ArrayList<Location>();
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery("from Location");
        locations = (ArrayList<Location>) q.list();
        return locations;
    }

    public Location getLocationById(Integer movieId) {
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("video");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(Location.class, 1L);
        
    }

    public void update(Location l) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(l);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}

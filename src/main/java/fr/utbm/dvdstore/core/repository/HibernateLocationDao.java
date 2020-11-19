package fr.utbm.dvdstore.core.repository;

import fr.utbm.dvdstore.core.entity.Location;
import fr.utbm.dvdstore.core.tools.HibernateUtil;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HibernateLocationDao {

    Transaction transaction = null;

    public void save(Location f) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(f);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public ArrayList<Location> listFilm() {
        ArrayList<Location> films = new ArrayList<Location>();
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery("from Location");
        films = (ArrayList<Location>) q.list();
        return films;
    }

    public Location getLocationById(Integer movieId) {
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("video");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(Location.class, 1L);
        
//        Location movie = null;
//        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
//            Query q = session.createQuery("from Location where id = :idmovie");
//            q.setParameter("idmovie", movieId);
//            movie = (Location) q.uniqueResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return movie;
    }

    public void update(Location f) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(f);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}

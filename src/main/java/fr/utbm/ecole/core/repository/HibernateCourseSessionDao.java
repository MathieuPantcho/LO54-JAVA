package fr.utbm.ecole.core.repository;

import fr.utbm.ecole.core.entity.CourseSession;
import fr.utbm.ecole.core.tools.HibernateUtil;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HibernateCourseSessionDao {

    Transaction transaction = null;

    public void save(CourseSession cs) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(cs);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public ArrayList<CourseSession> listFilm() {
        ArrayList<CourseSession> films = new ArrayList<CourseSession>();
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery("from Course_Session");
        films = (ArrayList<CourseSession>) q.list();
        return films;
    }

    public CourseSession getCourseSessionById(Integer coursesessionId) {
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("video");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(CourseSession.class, 1L);
        
    }

    public void update(CourseSession cs) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(cs);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}

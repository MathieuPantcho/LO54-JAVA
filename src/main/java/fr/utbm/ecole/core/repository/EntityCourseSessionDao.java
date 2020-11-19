
package fr.utbm.ecole.core.repository;

import fr.utbm.ecole.core.entity.CourseSession;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EntityCourseSessionDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecole");
    EntityManager entityManager = null;

    public void save(CourseSession f) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(f);
        entityManager.getTransaction().commit();
    }

    public ArrayList<CourseSession> listCourseSession() {
        ArrayList<CourseSession> CourseSessions = new ArrayList<CourseSession>();
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery("from COURSE_SESSION");
        CourseSessions = (ArrayList<CourseSession>) q.getResultList();
        return CourseSessions;
    }

    public CourseSession getCourseSessionById(Long CourseSessionsId) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(CourseSession.class, CourseSessionsId);
    }

    public void update(CourseSession cs) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(cs);
        entityManager.getTransaction().commit();
    }
}

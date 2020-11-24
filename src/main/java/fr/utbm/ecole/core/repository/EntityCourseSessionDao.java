
package fr.utbm.ecole.core.repository;

import fr.utbm.ecole.core.entity.Course;
import fr.utbm.ecole.core.entity.CourseSession;
import java.util.List;
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

    public List<CourseSession> listCourseSession() {
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery("select cs from CourseSession cs");
        List<CourseSession> CourseSessions = q.getResultList();
        return CourseSessions;
    }

    public CourseSession getCourseSessionById(Integer CourseSessionsId) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(CourseSession.class, CourseSessionsId);
    }
    
    public List<CourseSession> getCourseSessionByTitleCourse(String title) {
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery("SELECT CS FROM CourseSession CS JOIN cs.Course c WHERE c.title LIKE :custTitle")
                                            .setParameter("custTitle", '%'+title+'%');
        List<CourseSession> CourseSessions = q.getResultList();
        return CourseSessions;
    }

    public void update(CourseSession cs) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(cs);
        entityManager.getTransaction().commit();
    }
}

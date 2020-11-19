
package fr.utbm.ecole.core.repository;

import fr.utbm.ecole.core.entity.Course;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EntityCourseDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecole");
    EntityManager entityManager = null;

    public void save(Course c) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(c);
        entityManager.getTransaction().commit();
    }

    public ArrayList<Course> listCourse() {
        ArrayList<Course> Courses = new ArrayList<Course>();
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery("from COURSE");
        Courses = (ArrayList<Course>) q.getResultList();
        return Courses;
    }

    public Course getCourseById(Long courseId) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Course.class, courseId);
    }

    public void update(Course c) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(c);
        entityManager.getTransaction().commit();
    }
}

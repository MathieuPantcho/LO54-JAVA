
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

    public void save(Course f) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(f);
        entityManager.getTransaction().commit();
    }

    public ArrayList<Course> listFilm() {
        ArrayList<Course> films = new ArrayList<Course>();
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery("from LOCATION");
        films = (ArrayList<Course>) q.getResultList();
        return films;
    }

    public Course getCourseById(Long movieId) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Course.class, movieId);
    }

    public void update(Course f) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(f);
        entityManager.getTransaction().commit();
    }
}

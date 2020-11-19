
package fr.utbm.ecole.core.repository;

import fr.utbm.ecole.core.entity.Location;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EntityLocationDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecole");
    EntityManager entityManager = null;

    public void save(Location f) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(f);
        entityManager.getTransaction().commit();
    }

    public ArrayList<Location> listFilm() {
        ArrayList<Location> films = new ArrayList<Location>();
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery("from LOCATION");
        films = (ArrayList<Location>) q.getResultList();
        return films;
    }

    public Location getLocationById(Long movieId) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Location.class, movieId);
    }

    public void update(Location f) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(f);
        entityManager.getTransaction().commit();
    }
}

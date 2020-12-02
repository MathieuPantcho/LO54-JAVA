
package fr.utbm.ecole.core.repository;

import fr.utbm.ecole.core.entity.Location;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EntityLocationDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecole");
    EntityManager entityManager = null;

    public void save(Location l) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(l);
        entityManager.getTransaction().commit();
    }

    public List<Location> listLocation() {
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery("select l from Location l");
        List<Location> locactions =  q.getResultList();
        return locactions;
    }

    public Location getLocationById(Integer locationId) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Location.class, locationId);
    }

    public void update(Location l) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(l);
        entityManager.getTransaction().commit();
    }
}


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

    public void save(Location l) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(l);
        entityManager.getTransaction().commit();
    }

    public ArrayList<Location> listLocation() {
        ArrayList<Location> locactions = new ArrayList<Location>();
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery("from LOCATION");
        locactions = (ArrayList<Location>) q.getResultList();
        return locactions;
    }

    public Location getLocationById(Long locationId) {
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

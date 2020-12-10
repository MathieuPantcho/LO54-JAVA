
package fr.utbm.ecole.core.repository;

import fr.utbm.ecole.core.entity.Client;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EntityClientDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecole");
    EntityManager entityManager = null;

    public void save(Client c) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(c);
        entityManager.getTransaction().commit();
    }

    public List<Client> listClient() {
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery("select c from Client c");
        List<Client> Courses = q.getResultList();
        return Courses;
    }

    public Client getClientById(Integer clientId) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Client.class, clientId);
    }
    
    public Integer NbClient(Integer id) {
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery("SELECT c FROM Client C JOIN c.CourseSession cs WHERE cs.id = :custid ")
                                            .setParameter("custid", id);
        List list = q.getResultList();
        int nb = list.size();
        return nb;
    }
    public void update(Client c) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(c);
        entityManager.getTransaction().commit();
    }
}

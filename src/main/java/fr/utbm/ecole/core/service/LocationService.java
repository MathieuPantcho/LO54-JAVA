package fr.utbm.ecole.core.service;

import fr.utbm.ecole.core.entity.Location;
import fr.utbm.ecole.core.repository.ConsoleLocationDao;
import fr.utbm.ecole.core.repository.EntityLocationDao;
import fr.utbm.ecole.core.repository.JdbcLocationDao;
import fr.utbm.ecole.core.repository.HibernateLocationDao;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class LocationService {

    public void registerLocation(Location f) {
        ConsoleLocationDao cfd = new ConsoleLocationDao();
        JdbcLocationDao jfd = new JdbcLocationDao();
        
        HibernateLocationDao hfd = new HibernateLocationDao();
        EntityLocationDao efd = new EntityLocationDao();

        cfd.save(f);
        
        jfd.save(f);
        efd.save(f);
        ArrayList<Location> list = jfd.listFilm();
        for (Location film : list) {
            cfd.save(film);
           
        }
       
    }
}

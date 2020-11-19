package fr.utbm.dvdstore.core.service;

import fr.utbm.dvdstore.core.entity.Location;
import fr.utbm.dvdstore.core.repository.ConsoleLocationDao;
import fr.utbm.dvdstore.core.repository.EntityLocationDao;
import fr.utbm.dvdstore.core.repository.FileLocationDao;
import fr.utbm.dvdstore.core.repository.JdbcLocationDao;
import fr.utbm.dvdstore.core.repository.HibernateLocationDao;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class LocationService {

    public void registerLocation(Location f) {
        ConsoleLocationDao cfd = new ConsoleLocationDao();
        FileLocationDao ffd = new FileLocationDao();
        JdbcLocationDao jfd = new JdbcLocationDao();
        
        HibernateLocationDao hfd = new HibernateLocationDao();
        EntityLocationDao efd = new EntityLocationDao();

        cfd.save(f);
        ffd.save(f);
        jfd.save(f);
        efd.save(f);
        ArrayList<Location> list = jfd.listFilm();
        for (Location film : list) {
            cfd.save(film);
            ffd.save(film);
        }
       
    }
}

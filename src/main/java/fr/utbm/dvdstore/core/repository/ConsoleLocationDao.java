package fr.utbm.dvdstore.core.repository;

import fr.utbm.dvdstore.core.entity.Location;

/**
 *
 * @author 
 */
public class ConsoleLocationDao {

    public void save(Location f) {
        System.out.println(f.toString());
    }
}

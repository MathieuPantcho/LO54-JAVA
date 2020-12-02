package fr.utbm.ecole.core.repository;

import fr.utbm.ecole.core.entity.Location;

/**
 *
 * @author 
 */
public class ConsoleLocationDao {

    public void save(Location f) {
        System.out.println(f.toString());
    }
}

package fr.utbm.ecole.core.repository;

import fr.utbm.ecole.core.entity.Client;

/**
 *
 * @author 
 */
public class ConsoleClientDao {

    public void save(Client c) {
        System.out.println(c.toString());
    }
}

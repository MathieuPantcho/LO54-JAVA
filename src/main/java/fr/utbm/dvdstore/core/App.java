package fr.utbm.dvdstore.core;

import fr.utbm.dvdstore.core.controller.DefaultLocationController;

/**
 *
 * @author
 */
public class App {

    public static void main(String[] args) {
        DefaultLocationController dfc = new DefaultLocationController();
        dfc.registerLocationFromConsoleInput();
    }
}

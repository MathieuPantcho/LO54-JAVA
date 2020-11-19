package fr.utbm.ecole.core;

import fr.utbm.ecole.core.controller.DefaultLocationController;

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

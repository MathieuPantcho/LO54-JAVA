package fr.utbm.ecole.core;

import fr.utbm.ecole.core.controller.DefaultClientController;

/**
 *
 * @author
 */
public class Client {

    public static void main(String[] args) {
        DefaultClientController dfc = new DefaultClientController();
        dfc.registerCourseFromConsoleInput();
    }
}

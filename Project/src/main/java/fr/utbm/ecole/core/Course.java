package fr.utbm.ecole.core;



import fr.utbm.ecole.core.controller.DefaultCourseController;

public class Course {

    public static void main(String[] args) {
        DefaultCourseController dfc = new DefaultCourseController();
        dfc.registerCourseFromConsoleInput();
    }
}

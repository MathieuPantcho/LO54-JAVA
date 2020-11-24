package fr.utbm.ecole.core;

import fr.utbm.ecole.core.controller.DefaultCourseSessionController;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class CourseSession {

    public static void main(String[] args) {
        DefaultCourseSessionController dfcs = new DefaultCourseSessionController();
        /**
        try {
            dfcs.registerCourseSessionFromConsoleInput();
        } catch (ParseException ex) {
            Logger.getLogger(CourseSession.class.getName()).log(Level.SEVERE, null, ex);
        }
        **/
        dfcs.getCourseSessionFromConsoleInput();

        
    }
}

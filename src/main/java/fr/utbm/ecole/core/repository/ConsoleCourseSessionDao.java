package fr.utbm.ecole.core.repository;

import fr.utbm.ecole.core.entity.CourseSession;

/**
 *
 * @author 
 */
public class ConsoleCourseSessionDao {

    public void save(CourseSession cs) {
        System.out.println(cs.toString());
    }
}

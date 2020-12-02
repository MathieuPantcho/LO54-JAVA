package fr.utbm.ecole.core.repository;

import fr.utbm.ecole.core.entity.Course;

/**
 *
 * @author 
 */
public class ConsoleCourseDao {

    public void save(Course f) {
        System.out.println(f.toString());
    }
}

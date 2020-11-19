package fr.utbm.ecole.core.service;

import fr.utbm.ecole.core.entity.Course;
import fr.utbm.ecole.core.repository.ConsoleCourseDao;
import fr.utbm.ecole.core.repository.EntityCourseDao;
import fr.utbm.ecole.core.repository.JdbcCourseDao;
import fr.utbm.ecole.core.repository.HibernateCourseDao;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class CourseService {

    public void registerCourse(Course f) {
        ConsoleCourseDao cfd = new ConsoleCourseDao();
        JdbcCourseDao jfd = new JdbcCourseDao();
        
        HibernateCourseDao hfd = new HibernateCourseDao();
        EntityCourseDao efd = new EntityCourseDao();

        cfd.save(f);
        jfd.save(f);
        efd.save(f);
        ArrayList<Course> list = jfd.listFilm();
        for (Course film : list) {
            cfd.save(film);
        }
       
    }
}

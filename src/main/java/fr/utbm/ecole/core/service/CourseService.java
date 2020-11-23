package fr.utbm.ecole.core.service;

import fr.utbm.ecole.core.entity.Course;
import fr.utbm.ecole.core.repository.ConsoleCourseDao;
import fr.utbm.ecole.core.repository.EntityCourseDao;
import java.util.List;

/**
 *
 * @author
 */
public class CourseService {

    public void registerCourse(Course f) {
        ConsoleCourseDao cfd = new ConsoleCourseDao();
        EntityCourseDao efd = new EntityCourseDao();

        cfd.save(f);

        efd.save(f);
        List<Course> list = efd.listCourse();
        for (Course Course : list) {
            cfd.save(Course);
        }

    }

    public Course searchCourseById(String CodeCourse){
        EntityCourseDao efd = new EntityCourseDao();
        return efd.getCourseById(CodeCourse);
    }
}
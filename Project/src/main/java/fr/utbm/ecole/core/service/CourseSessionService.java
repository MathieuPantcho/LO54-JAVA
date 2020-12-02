package fr.utbm.ecole.core.service;

import fr.utbm.ecole.core.entity.CourseSession;
import fr.utbm.ecole.core.entity.Location;
import fr.utbm.ecole.core.repository.ConsoleCourseSessionDao;
import fr.utbm.ecole.core.repository.EntityCourseSessionDao;
import fr.utbm.ecole.core.repository.EntityLocationDao;
import java.util.List;

/**
 *
 * @author MathieuPANTCHENKO
 */
public class CourseSessionService {
     public void registerCourseSession(CourseSession cs) {
        ConsoleCourseSessionDao csd = new ConsoleCourseSessionDao();
        EntityCourseSessionDao esd = new EntityCourseSessionDao();

        csd.save(cs);
     
        esd.save(cs);
        List<CourseSession> list = esd.listCourseSession();
        for (CourseSession CourseSess : list) {
            csd.save(CourseSess);
        }
       
    }   
    
    public CourseSession searchCourseSessionById(Integer idCourseSession) {
        EntityCourseSessionDao efd = new EntityCourseSessionDao();
        return efd.getCourseSessionById(idCourseSession);
    }
    
    public void searchCourseSessionByTitleCourse(String title) {
        ConsoleCourseSessionDao csd = new ConsoleCourseSessionDao();
        EntityCourseSessionDao esd = new EntityCourseSessionDao();
        List<CourseSession> list = esd.getCourseSessionByTitleCourse(title);
        for (CourseSession CourseSess : list) {
            csd.save(CourseSess);
        }
    }
    
    public void searchCourseSessionByLocation(String city) {
        ConsoleCourseSessionDao csd = new ConsoleCourseSessionDao();
        EntityCourseSessionDao esd = new EntityCourseSessionDao();
        List<CourseSession> list = esd.getCourseSessionByLocation(city);
        for (CourseSession CourseSess : list) {
            csd.save(CourseSess);
        }
    }
    
    public void searchCourseSessionByDate(java.sql.Date date) {
        ConsoleCourseSessionDao csd = new ConsoleCourseSessionDao();
        EntityCourseSessionDao esd = new EntityCourseSessionDao();
        List<CourseSession> list = esd.getCourseSessionByDate(date);
        for (CourseSession CourseSess : list) {
            csd.save(CourseSess);
        }
    }
}
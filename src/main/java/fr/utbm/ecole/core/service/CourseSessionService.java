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
}
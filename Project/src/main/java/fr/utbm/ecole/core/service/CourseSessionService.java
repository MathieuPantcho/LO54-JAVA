package fr.utbm.ecole.core.service;

import fr.utbm.ecole.core.entity.CourseSession;
import fr.utbm.ecole.core.entity.Location;
import fr.utbm.ecole.core.repository.ConsoleCourseSessionDao;
import fr.utbm.ecole.core.repository.EntityCourseSessionDao;
import fr.utbm.ecole.core.repository.EntityLocationDao;
import fr.utbm.ecole.core.repository.EntityClientDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import java.util.ArrayList;

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
    
    public  List<CourseSession> searchCourseSessionByTitleCourse(String title) {
        EntityCourseSessionDao esd = new EntityCourseSessionDao();
        List<CourseSession> list = esd.getCourseSessionByTitleCourse(title);
        return list;
    }
    
    public List<CourseSession>  searchCourseSessionByLocation(String city) {
        EntityCourseSessionDao esd = new EntityCourseSessionDao();
        List<CourseSession> list = esd.getCourseSessionByLocation(city);
        return list;
    }
    
    public List<CourseSession> searchCourseSessionByDate(java.sql.Date date) {
        EntityCourseSessionDao esd = new EntityCourseSessionDao();
        List<CourseSession> list = esd.getCourseSessionByDate(date);
        return list;
    }
    
    
    public List<CourseSession> searchCourseSessionByDateString(String date){
        EntityCourseSessionDao esd = new EntityCourseSessionDao();
        List<CourseSession> list  = new ArrayList<>();
        try {
            java.sql.Date DateSQL = StringtoSQLDate(date);
             List<CourseSession> listDate = esd.getCourseSessionByDate(DateSQL);
            return listDate;
        }
        catch (Exception e) { }
        
        return list;
        
    }
    
    public java.sql.Date StringtoSQLDate(String start_date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date parsed = format.parse(start_date);
        java.sql.Date DateSQL = new java.sql.Date(parsed.getTime());
        return DateSQL;
    }
    public  List<CourseSession> listCourseSession() {
        
        EntityCourseSessionDao efd = new EntityCourseSessionDao();
        return efd.listCourseSession();
    }
    
    public float GetNbClientCourseSession(CourseSession cs) {
        
        EntityClientDao ecd = new EntityClientDao();
        int nb = ecd.NbClient(cs.getId());
        return nb;
    }
    
}
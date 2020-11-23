package fr.utbm.ecole.core.controller;

import fr.utbm.ecole.core.entity.Course;
import fr.utbm.ecole.core.repository.EntityCourseDao;
import fr.utbm.ecole.core.entity.Location;
import fr.utbm.ecole.core.entity.CourseSession;
import fr.utbm.ecole.core.service.CourseService;
import fr.utbm.ecole.core.service.LocationService;
import fr.utbm.ecole.core.service.CourseSessionService;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 
 */
public class DefaultCourseSessionController {

    public void registerCourseSessionFromConsoleInput() throws ParseException{

        Scanner sc = new Scanner(System.in);
//        System.out.println("Id Course Session ?");
//        String Id = sc.nextLine();

        System.out.println("StartDate Course Session (format : YYYYMMDD)?");
        String StartDate = sc.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date parsed = format.parse(StartDate);
        java.sql.Date StartDateSQL = new java.sql.Date(parsed.getTime());

        System.out.println("EndDate Course Session (format : YYYYMMDD)?");
        String EndDate = sc.nextLine();
        SimpleDateFormat formatSecond = new SimpleDateFormat("yyyyMMdd");
        Date parsedSecond = formatSecond.parse(EndDate);
        java.sql.Date EndDateSQL = new java.sql.Date(parsedSecond.getTime());

        System.out.println("Maximum Course Session ?");
        String Maximum = sc.nextLine();

        System.out.println("Course Course Session ?");
        String Course = sc.nextLine();

        System.out.println("Location Course Session ?");
        String idLocation = sc.nextLine();


        CourseSession cs = new CourseSession();
        //cs.setId(Long.parseLong(Id));
        cs.setStartDate(StartDateSQL);
        cs.setEndDate(EndDateSQL);
        cs.setMaximum(Integer.parseInt(Maximum));
        cs.setCourse(searchCourseFromId(Course));
        cs.setLocation(searchLocationFromId(Integer.parseInt(idLocation)));



        CourseSessionService css = new CourseSessionService();
        css.registerCourseSession(cs);
    }

        public Course searchCourseFromId(String CodeCourse) {
        CourseService fs = new CourseService();
        Course Course = fs.searchCourseById(CodeCourse);
        return Course;
    }
        
    
    public Location searchLocationFromId(Integer idLocation) {

        LocationService fs = new LocationService();
        Location Location = fs.searchLocationById(idLocation);
        return Location;
    }
}
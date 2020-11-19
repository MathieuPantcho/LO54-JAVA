package fr.utbm.ecole.core.controller;

import fr.utbm.ecole.core.entity.Course;
import fr.utbm.ecole.core.service.CourseService;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class DefaultClientController {
    
    public void registerCourseFromConsoleInput(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Firstname ?");
        String Firstname = sc.nextLine();
           
        System.out.println("LastName ?");
        String LastName = sc.nextLine();
        
        System.out.println("Address ?");
        String Address = sc.nextLine();
        
        System.out.println("phone?");
        String phone = sc.nextLine();
        
        System.out.println("email ?");
        String email = sc.nextLine();
        
        System.out.println("Course Session ?");
        String CourseSession = sc.nextLine();
        
        Course c = new Course();
        c.setCode(Firstname);
        c.setTitle(LastName);
        c.setCode(Address);
        c.setTitle(phone);
        c.setCode(email);
        c.setTitle(CourseSession);
        
        CourseService cs = new CourseService();
        cs.registerCourse(c);
    }
}

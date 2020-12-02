package fr.utbm.ecole.core.controller;

import fr.utbm.ecole.core.entity.Client;
import fr.utbm.ecole.core.entity.CourseSession;
import fr.utbm.ecole.core.service.ClientService;
import fr.utbm.ecole.core.service.CourseSessionService;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class DefaultClientController {
    
    public void registerClientFromConsoleInput(){
        
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
        
        System.out.println("Course Session ID ?");
        String idCourseSession = sc.nextLine();
        
        Client c = new Client();
        c.setFirstname(Firstname);
        c.setLastname(LastName);
        c.setAddress(Address);
        c.setPhone(phone);
        c.setEmail(email);
        c.setCourseSession(searchCourseSessionFromId(Integer.parseInt(idCourseSession)));

     
        
        ClientService cs = new ClientService();
        cs.registerClient(c);
    }
    
    public CourseSession searchCourseSessionFromId(Integer idCourseSession) {
        CourseSessionService fs = new CourseSessionService();
        CourseSession CourseSession = fs.searchCourseSessionById(idCourseSession);
        return CourseSession;
    }
}

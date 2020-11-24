package fr.utbm.ecole.core.controller;

import fr.utbm.ecole.core.entity.Course;
import fr.utbm.ecole.core.service.CourseService;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author 
 */
public class DefaultCourseController {
    
    public void registerCourseFromConsoleInput(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Code Course ?");
        String Code = sc.nextLine();
           
        System.out.println("Title Course ?");
        String Title = sc.nextLine();
        
        
        Course f = new Course();
        f.setCode(Code);
        f.setTitle(Title);
        
        CourseService fs = new CourseService();
        fs.registerCourse(f);
    }
    
    public Course searchCourseFromId(String CodeCourse) {
        CourseService fs = new CourseService();
        Course Course = fs.searchCourseById(CodeCourse);
        return Course;
    }
    public List<Course> FindCourseFromTitle(String Title){
        CourseService fs = new CourseService();
        return fs.getCourseByTitle(Title);
    }
}

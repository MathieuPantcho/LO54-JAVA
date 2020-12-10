/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.core.service;

import fr.utbm.ecole.core.entity.Course;
import fr.utbm.ecole.core.repository.ConsoleCourseDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import redis.clients.jedis.Jedis;
import fr.utbm.ecole.core.repository.RedisServiceDao;

/**
 *
 * @author MathieuPANTCHENKO
 */
public class CourseServiceRedis {
        
    public void registerCourseRedis(Course c) {
        RedisServiceDao rsd = new RedisServiceDao();
        rsd.registerCourseRedis(c);
        List<Course> list = rsd.seeAllValues();
        ConsoleCourseDao ccd = new ConsoleCourseDao();
        for(Course course : list){
            ccd.save(course);
        }
    }
    
    public List<Course> seeAllValues(){
        RedisServiceDao rsd = new RedisServiceDao();
        return rsd.seeAllValues();
    }
    
}

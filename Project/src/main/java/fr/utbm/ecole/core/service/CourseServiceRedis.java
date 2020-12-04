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

/**
 *
 * @author MathieuPANTCHENKO
 */
public class CourseServiceRedis {
        
    public void registerCourseRedis(Course f) {
        Jedis jedis = new Jedis();
        jedis.set(f.getCode(), f.getTitle());
        List<Course> list = seeAllValues();
        ConsoleCourseDao ccd = new ConsoleCourseDao();
        for(Course course : list){
            ccd.save(course);
        }
    }
    
    public List<Course> seeAllValues(){
        List<Course> result = new ArrayList<Course>();
        Jedis jedis = new Jedis();
        Set<String> redis = jedis.keys("*");
        for(String key : redis){
            String value = jedis.get(key);
            String strResult = key + " : " + value;
            result.add(new Course(key,value));
        }
        return result;
    }
}

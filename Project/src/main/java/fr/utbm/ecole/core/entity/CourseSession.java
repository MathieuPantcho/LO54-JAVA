/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.core.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

/**
 *
 * @author 
 */
@Entity
@Table(name = "COURSE_SESSION")
public class CourseSession implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "START_DATE")
    private java.sql.Date start_date;
    
    @Basic(optional = false)
    @Column(name = "END_DATE")
    private java.sql.Date end_date;
    
    @Basic(optional = false)
    @Column(name = "MAXIMUM")
    private Integer maximum;
      
    @JoinColumn(name = "COURSE_CODE")
    @ManyToOne(fetch = FetchType.EAGER)
    private Course Course;
    
    @JoinColumn(name = "LOCATION_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Location Location;
     
    
  
    public CourseSession() {
    }

    public CourseSession(Integer id) {
        this.id = id;
    }

    public CourseSession(Integer id, java.sql.Date start_date,java.sql.Date end_date,Integer maximum,Course Course,Location Location) {
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.maximum = maximum;
        this.Course = Course;
        this.Location = Location;
    }
    
    public CourseSession(Integer id, java.sql.Date start_date,java.sql.Date end_date,Course Course,Location Location) {
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.Course = Course;
        this.Location = Location;
    }

    public void setCourse(Course Course) {
        this.Course = Course;
    }

    public Course getCourse() {
        return Course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.sql.Date getStartDate() {
        return start_date;
    }

    public void setStartDate(java.sql.Date start_date) {
        this.start_date = start_date;
    }
    
    public void setStartDate(String start_date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date parsed = format.parse(start_date);
        java.sql.Date StartDateSQL = new java.sql.Date(parsed.getTime());
        this.start_date = StartDateSQL;
    }
    
     public java.sql.Date getEndDate() {
        return end_date;
    }

    public void setEndDate(java.sql.Date end_date) {
        this.end_date = end_date;
    }
    
    public void setEndDate(String end_date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date parsed = format.parse(end_date);
        java.sql.Date StartDateSQL = new java.sql.Date(parsed.getTime());
        this.end_date = StartDateSQL;
    }
    
     public Location getLocation() {
        return Location;
    }

    public void setLocation(Location Location) {
        this.Location = Location;
    }
    
     public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

   
    public String toString() {
        return "Course_session{" + "id=" + id + ", start_date=" + start_date  + ", end_date=" + end_date + ", Location=" + Location + "maximum=" + maximum + ", Course=" + Course +'}';
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.core.entity;

import java.io.Serializable;
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
public class Course_Session implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "START_DATE")
    private Date start_date;
    
    @Basic(optional = false)
    @Column(name = "END_DATE")
    private Date end_date;
    
    @Basic(optional = false)
    @Column(name = "MAXIMUM")
    private Integer maximum;
      
    @JoinColumn(name = "COURSE_CODE")
    @ManyToOne(fetch = FetchType.EAGER)
    private Course Course;
    
    @JoinColumn(name = "LOCATION_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Location Location;
     
    
  
    public Course_Session() {
    }

    public Course_Session(Long id) {
        this.id = id;
    }

    public Course_Session(Long id, Date start_date,Date end_date,Integer maximum,Course Course,Location Location) {
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.maximum = maximum;
        this.Course = Course;
        this.Location = Location;
    }
    
    public Course_Session(Long id, Date start_date,Date end_date,Course Course,Location Location) {
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.Course = Course;
        this.Location = Location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return start_date;
    }

    public void setStartDate(Date start_date) {
        this.start_date = start_date;
    }
    
     public Date getEndDate() {
        return end_date;
    }

    public void setEndDate(Date end_date) {
        this.end_date = end_date;
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
        return "Client{" + "id=" + id + ", start_date=" + start_date  + "end_date=" + end_date + ", Location=" + Location + "maximum=" + maximum + ", Course=" + Course +'}';
    }
    
}

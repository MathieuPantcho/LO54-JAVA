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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 
 */
@Entity
@Table(name = "COURSE")
public class Course implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "CODE")
    private String code;
    
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    
  
    public Course() {
    }

    public Course(String code) {
        this.code = code;
    }

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

   
    public String toString() {
        return "Location{" + "code=" + code + ", title=" + title +  '}';
    }
    
}

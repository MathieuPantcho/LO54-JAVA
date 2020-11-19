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

/**
 *
 * @author 
 */
@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "LASTNAME")
    private String lastname;
    
    @Basic(optional = false)
    @Column(name = "FIRSTNAME")
    private String firstname;
    
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
      
    @Basic(optional = false)
    @Column(name = "PHONE")
    private String phone;
    
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
     
    @JoinColumn(name = "COURSE_SESSION_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Course_Session Course_Session;
  
    public Client() {
    }

    public Client(Long id) {
        this.id = id;
    }

    public Client(Long id, String lastname, String firstname, String address,String phone,String email, Course_Session Course_Session) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;        
        this.email = email;
        this.Course_Session = Course_Session;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

   
    public String toString() {
        return "Client{" + "id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", address=" + address + ", phone=" + phone + ", email=" + email + ", Course_Session=" + Course_Session +  '}';
    }
    
}

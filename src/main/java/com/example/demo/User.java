package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MyUserTable")
public class User {
    
    private @Id @GeneratedValue Long id;

    private String firstName;
    private String lastName;
    
    public User(){
    }
    
    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Long getId() {
        return id;
    }
     
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}

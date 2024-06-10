package com.example.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Player {
    private String name;
    private String vipperson;
    private boolean isActive;
    
    public Player(String Name, String VIPPerson){
    	this.name=Name;
        this.vipperson=VIPPerson;
        
    }
    public void setVIPerson(String vipperson){
        this.vipperson=vipperson;
    }
    public String getName(){
    	return name;
    }
    public String getVIPerson(){
    	return vipperson;
    }

    // Constructor, getters and setters
}

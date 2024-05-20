package com.example.application;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private String vipperson;
    private boolean isActive;
    
    public Player(String Name, String VIPPerson){
    	this.name=Name;
        this.vipperson=VIPPerson;
        
    }
    
    public String getName(){
    	return name;
    }
    public String getVIPerson(){
    	return vipperson;
    }

    // Constructor, getters and setters
}

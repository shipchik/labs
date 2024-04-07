package com.company.professions;

public class Driver extends Person {
    private String fullName;
    private int experience;
    public Driver(String name){
        this.fullName = name;
    }
    public Driver(String fullName, int experience) {
        this.fullName = fullName;
        this.experience = experience;
    }


}
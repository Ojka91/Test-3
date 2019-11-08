package com.ssiconcatel.test3;

import java.util.List;

public class Rebel {

    private String name;
    private String planet;

    private List<String> rebelInfo;

    public Rebel(){

    }

    //Constructor to accept list of Strings
    public Rebel (List<String> rebelInfo){
        this.rebelInfo = rebelInfo;
    }

    //constructor to accept json format
    public Rebel(String name, String planet){
        this.name = name;
        this.planet = planet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public List<String> getRebelInfo() {
        return rebelInfo;
    }

    public void setRebelInfo(List<String> rebelInfo) {
        this.rebelInfo = rebelInfo;
    }
}

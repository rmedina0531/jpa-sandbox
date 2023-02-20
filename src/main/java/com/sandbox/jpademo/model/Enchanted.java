package com.sandbox.jpademo.model;

import lombok.ToString;

@ToString
public abstract class Enchanted {
    public int idNum;
    public String schoolID;
    public String itemType;

    public Enchanted(String forWhichSchool, String itemType){
        this.schoolID = forWhichSchool;
        this.itemType = itemType;
    }

    public int getIdNum(){return this.idNum;}
    public void print() { System.out.println(idNum + " " + schoolID);}
}
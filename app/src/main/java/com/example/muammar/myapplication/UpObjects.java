package com.example.muammar.myapplication;

/**
 * Created by Muammar on 10/23/2016.
 */
public class UpObjects {

    public  String type;
    public  int value;
    public String current;
    public String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }



    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public UpObjects() {

    }

    public UpObjects(String ty, int val, String cur,String nutes) {
        this.type = ty;
        this.value = val;
        this.current = cur;
        this.notes = nutes;


    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public  int getValue() {
        return value;
    }

    public  String getType() {
        return type;
    }
}

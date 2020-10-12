package com.mycompany.access;

public class Persona {

    private String id;
    private String Name;
    private String mobile;
    
    public Persona(String id, String Name, String mobile) {
        this.id = id;
        this.Name = Name;
        this.mobile = mobile;
    }

    public Persona() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
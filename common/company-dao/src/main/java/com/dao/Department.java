package com.dao;

public class Department {
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCamid() {
        return Camid;
    }

    public void setCamid(int camid) {
        Camid = camid;
    }

    public int getEmpid() {
        return Empid;
    }

    public void setEmpid(int empid) {
        Empid = empid;
    }

    private int Id;
    private String name;
    private int Camid;
    private int Empid;

    public int getDepid() {
        return Depid;
    }

    public void setDepid(int depid) {
        Depid = depid;
    }

    private int Depid;
}

package com.dao;

public class Employee {
    private int Id;
    private String Name;
    private int Depid;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getDepid() {
        return Depid;
    }

    public void setDepid(int depid) {
        Depid = depid;
    }

    public int getEmpid() {
        return Empid;
    }

    public void setEmpid(int empid) {
        Empid = empid;
    }

    private int Empid;
}

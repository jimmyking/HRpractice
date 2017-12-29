package com.seendio.hr.dao.pojo;

public class Department {
    private int Id;
    private String name;
    private int Camid;
    private int Empid;
    private int Depid;
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



    public int getDepid() {
        return Depid;
    }

    public void setDepid(int depid) {
        Depid = depid;
    }


}

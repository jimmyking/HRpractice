package com.seendio.hr.dao.pojo;

import java.util.List;

/**
 * 树对象
 */
public class Node {
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int  getDepid() {
        return Depid;
    }

    public void setDepid(int depid) {
        Depid = depid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<com.seendio.hr.dao.pojo.Node> getChildren() {
        return children;
    }

    public void setChildren(List<com.seendio.hr.dao.pojo.Node> children) {
        this.children = children;
    }

    private int Id;
    private int Depid;
    private String Name;
    private List<com.seendio.hr.dao.pojo.Node> children;
}

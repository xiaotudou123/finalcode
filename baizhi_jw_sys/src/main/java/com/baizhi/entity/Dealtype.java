package com.baizhi.entity;

import java.util.List;

public class Dealtype {
    private String id;

    private String name;

    private String flag;

    private String parentid;

    //维护关系属性
    private List<Deal> deals;
    private List<Dealtype> dealtypes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }

    public List<Dealtype> getDealtypes() {
        return dealtypes;
    }

    public void setDealtypes(List<Dealtype> dealtypes) {
        this.dealtypes = dealtypes;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    @Override
    public String toString() {
        return "Dealtype{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", flag='" + flag + '\'' +
                ", parentid='" + parentid + '\'' +
                ", deals=" + deals +
                ", dealtypes=" + dealtypes +
                '}';
    }
}
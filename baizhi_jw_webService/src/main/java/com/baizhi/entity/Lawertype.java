package com.baizhi.entity;

import java.util.List;

public class Lawertype {
    private String id;

    private String name;


    //维护关系属性
    private List<Lawer> lawers;



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

    public List<Lawer> getLawers() {
        return lawers;
    }

    public void setLawers(List<Lawer> lawers) {
        this.lawers = lawers;
    }




    @Override
    public String toString() {
        return "Lawertype{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lawers=" + lawers +
                '}';
    }
}
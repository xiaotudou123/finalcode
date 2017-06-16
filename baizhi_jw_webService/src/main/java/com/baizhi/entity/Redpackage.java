package com.baizhi.entity;

import java.math.BigDecimal;

public class Redpackage {
    private String id;

    private BigDecimal redpackage;

    private String content;

    //维护关系属性
    private User user;
    private Lawer lawer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getRedpackage() {
        return redpackage;
    }

    public void setRedpackage(BigDecimal redpackage) {
        this.redpackage = redpackage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lawer getLawer() {
        return lawer;
    }

    public void setLawer(Lawer lawer) {
        this.lawer = lawer;
    }

    @Override
    public String toString() {
        return "Redpackage{" +
                "id='" + id + '\'' +
                ", redpackage=" + redpackage +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", lawer=" + lawer +
                '}';
    }
}
package com.baizhi.entity;

public class Order {
    private String id;

    private String content;

    private String type;

    private Integer status;


    //维护关系属性
    private Lawer lawer;
    private User user;
    private Comment comment;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Lawer getLawer() {
        return lawer;
    }

    public void setLawer(Lawer lawer) {
        this.lawer = lawer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }



}
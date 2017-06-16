package com.baizhi.entity;

import java.util.Date;

public class Comment {
    private String id;

    private Double score;

    private String content;

    private Date createtime;

    //维护关系属性
    private Order order;
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", score=" + score +
                ", content='" + content + '\'' +
                ", createtime=" + createtime +
                ", order=" + order +
                ", user=" + user +
                '}';
    }
}
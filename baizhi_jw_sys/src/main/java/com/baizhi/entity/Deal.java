package com.baizhi.entity;

import java.util.Date;

public class Deal {
    private String id;

    private String title;

    private Date createtime;

    private String content;

    private String dealtypeid;

    //维护属性
    private Dealtype dealtype;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Dealtype getDealtype() {
        return dealtype;
    }

    public void setDealtype(Dealtype dealtype) {
        this.dealtype = dealtype;
    }

    public String getDealtypeid() {
        return dealtypeid;
    }

    public void setDealtypeid(String dealtypeid) {
        this.dealtypeid = dealtypeid;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", createtime=" + createtime +
                ", content='" + content + '\'' +
                ", dealtypeid='" + dealtypeid + '\'' +
                ", dealtype=" + dealtype +
                '}';
    }
}
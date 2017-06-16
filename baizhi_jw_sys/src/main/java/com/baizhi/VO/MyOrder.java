package com.baizhi.VO;

/**
 * Created by SY on 2017/6/13.
 */
public class MyOrder {
    private String id;
    private String uname;
    private String lname;
    private String type;
    private String content;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MyOrder{" +
                "id='" + id + '\'' +
                ", uname='" + uname + '\'' +
                ", lname='" + lname + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                '}';
    }
}

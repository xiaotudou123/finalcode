package com.baizhi.VO;

import java.math.BigDecimal;

/**
 * Created by SY on 2017/6/14.
 */
public class RedPackage {

    private String id;

    private BigDecimal redpackage;

    private String content;

    private String uname;

    private String lname;

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
}

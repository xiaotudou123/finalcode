package com.baizhi.VO;

import com.baizhi.entity.Lawertype;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SY on 2017/6/12.
 */
public class My<T> implements Serializable{

    private List<T> rows;
    private Integer total;

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Util{" +
                "rows=" + rows +
                ", total=" + total +
                '}';
    }
}

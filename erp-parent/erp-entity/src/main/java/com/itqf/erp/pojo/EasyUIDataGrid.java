package com.itqf.erp.pojo;

import java.util.List;

/**
 * @author 飞鸟
 * @date 2019/7/9 - 10:18
 */
public class EasyUIDataGrid<T> {
    private long total;
    private List<T> rows;

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}

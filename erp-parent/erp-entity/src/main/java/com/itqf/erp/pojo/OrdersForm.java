package com.itqf.erp.pojo;

import java.util.List;

/**
 * @author 飞鸟
 * @date 2019/7/16 - 10:41
 */
public class OrdersForm {
    private Integer supplieruuid;
    private List<Orderdetail> json;

    public Integer getSupplieruuid() {
        return supplieruuid;
    }

    public void setSupplieruuid(Integer supplieruuid) {
        this.supplieruuid = supplieruuid;
    }

    public List<Orderdetail> getJson() {
        return json;
    }

    public void setJson(List<Orderdetail> json) {
        this.json = json;
    }
}

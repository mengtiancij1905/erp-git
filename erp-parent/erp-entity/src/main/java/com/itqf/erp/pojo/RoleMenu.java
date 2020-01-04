package com.itqf.erp.pojo;

public class RoleMenu {
    private Integer uuid;

    private Integer roleuuid;

    private String menuuuid;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getRoleuuid() {
        return roleuuid;
    }

    public void setRoleuuid(Integer roleuuid) {
        this.roleuuid = roleuuid;
    }

    public String getMenuuuid() {
        return menuuuid;
    }

    public void setMenuuuid(String menuuuid) {
        this.menuuuid = menuuuid == null ? null : menuuuid.trim();
    }
}
package com.kaiyu.pojo;

/**
 * @author mxxxl
 * @date 2020/8/21
 * @description
 */
public class RoleAndPermission {

    private Integer rid;
    private Integer pid;

    public RoleAndPermission() {
    }

    public RoleAndPermission(Integer rid, Integer pid) {
        this.rid = rid;
        this.pid = pid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "RoleAndPermission{" +
                "rid=" + rid +
                ", pid=" + pid +
                '}';
    }
}

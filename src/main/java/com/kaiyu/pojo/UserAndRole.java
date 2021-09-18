package com.kaiyu.pojo;

/**
 * @author mxxxl
 * @date 2020/8/21
 * @description
 */
public class UserAndRole {

    private Integer uid;
    private Integer rid;

    public UserAndRole() {
    }

    public UserAndRole(Integer uid, Integer rid) {
        this.uid = uid;
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "UserAndRole{" +
                "uid=" + uid +
                ", rid=" + rid +
                '}';
    }
}

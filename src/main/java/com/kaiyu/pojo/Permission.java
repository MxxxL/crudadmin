package com.kaiyu.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mxxxl
 * @date 2020/8/17
 * @description
 */
public class Permission {

    private Integer id;
    private Integer pid;
    private String name;
    private String percode;
    private List<Permission> childPermission = new ArrayList<>();

    public Permission() {
    }

    public Permission(Integer id, Integer pid, String name, String percode) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.percode = percode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercode() {
        return percode;
    }

    public void setPercode(String percode) {
        this.percode = percode;
    }

    public List<Permission> getChildPermission() {
        return childPermission;
    }

    public void setChildPermission(List<Permission> childPermission) {
        this.childPermission = childPermission;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", percode='" + percode + '\'' +
                ", childPermission=" + childPermission +
                '}';
    }
}

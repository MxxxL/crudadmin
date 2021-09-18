package com.kaiyu.pojo;

import java.util.List;

/**
 * @author mxxxl
 * @date 2020/8/21
 * @description
 */
public class ActiveUser {

    private User user;
    private String role;
    private List<String> permissions;

    public ActiveUser() {
    }

    public ActiveUser(User user, String role, List<String> permissions) {
        this.user = user;
        this.role = role;
        this.permissions = permissions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "ActiveUser{" +
                "user=" + user +
                ", role='" + role + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}

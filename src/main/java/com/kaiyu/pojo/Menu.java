package com.kaiyu.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mxxxl
 * @date 2020/8/17
 * @description
 */
public class Menu {

    private Integer id;
    private Integer pid;
    private String title;
    private String url;
    private String order;
    private List<Menu> childMenu = new ArrayList<>();

    public Menu() {
    }

    public Menu(Integer id, Integer pid, String title, String url, String order) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.url = url;
        this.order = order;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public List<Menu> getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(List<Menu> childMenu) {
        this.childMenu = childMenu;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", pid=" + pid +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", order='" + order + '\'' +
                ", childMenu=" + childMenu +
                '}';
    }
}

package com.kaiyu.pojo;

import java.util.Date;

/**
 * @author mxxxl
 * @date 2020/7/20
 * @description 员工表
 */
public class Employee {

    private Integer id;
    private String employeeName;
    private String email;
    /**
     * 0: 女  1： 男
     */
    private Integer gender;
    private Integer departmentId;
    private Date date;

    public Employee() {
    }

    public Employee(Integer id, String employeeName, String email, Integer gender,
                    Integer departmentId, Date date) {
        this.id = id;
        this.employeeName = employeeName;
        this.email = email;
        this.gender = gender;
        this.departmentId = departmentId;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", departmentId=" + departmentId +
                ", date=" + date +
                '}';
    }
}

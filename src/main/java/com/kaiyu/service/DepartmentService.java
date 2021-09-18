package com.kaiyu.service;

import com.kaiyu.pojo.Department;

import java.util.List;

/**
 * @author mxxxl
 * @date 2020/7/21
 * @description
 */
public interface DepartmentService {

    /**
     * 查询所有部门
     *
     * @return
     */
    List<Department> queryAll();
}

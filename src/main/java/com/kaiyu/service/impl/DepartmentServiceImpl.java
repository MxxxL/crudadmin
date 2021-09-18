package com.kaiyu.service.impl;

import com.kaiyu.dao.DepartmentMapper;
import com.kaiyu.pojo.Department;
import com.kaiyu.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mxxxl
 * @date 2020/7/21
 * @description
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> queryAll() {
        return departmentMapper.queryAll();
    }

}

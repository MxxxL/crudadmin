package com.kaiyu.service.impl;

import com.kaiyu.dao.EmployeeMapper;
import com.kaiyu.pojo.Employee;
import com.kaiyu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mxxxl
 * @date 2020/7/21
 * @description
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> queryAll() {
        return employeeMapper.queryAll();
    }

    @Override
    public Employee getEmpById(Integer id) {
        return employeeMapper.getEmpById(id);
    }

    @Override
    public int insertOneEmployee(Employee employee) {
        return employeeMapper.insertOneEmployee(employee);
    }

    @Override
    public int updateOneEmployee(Employee employee) {
        return employeeMapper.updateOneEmployee(employee);
    }

    @Override
    public int deleteOneEmployee(Integer id) {
        return employeeMapper.deleteOneEmployee(id);
    }
}

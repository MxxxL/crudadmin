package com.kaiyu.dao;

import com.kaiyu.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mxxxl
 * @date 2020/7/20
 * @description
 */
@Repository
public interface EmployeeMapper {

    /**
     * 查询所有
     *
     * @return
     */
    List<Employee> queryAll();

    /**
     * 根据id查询员工
     *
     * @param id
     * @return
     */
    Employee getEmpById(Integer id);

    /**
     * 添加单个员工信息
     *
     * @param employee
     * @return
     */
    int insertOneEmployee(Employee employee);

    /**
     * 更新单个员工信息
     *
     * @param employee
     * @return
     */
    int updateOneEmployee(Employee employee);

    /**
     * 根据id删除员工信息
     *
     * @param id
     * @return
     */
    int deleteOneEmployee(Integer id);
}

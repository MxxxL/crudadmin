package com.kaiyu.dao;

import com.kaiyu.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mxxxl
 * @date 2020/7/20
 * @description
 */
@Repository
public interface DepartmentMapper {

    /**
     * 查询所有
     *
     * @return
     */
    List<Department> queryAll();
}

package com.kaiyu.dao;

import com.kaiyu.pojo.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mxxxl
 * @date 2020/8/17
 * @description
 */
@Repository
public interface PermissionMapper {

    /**
     * 查询所有权限
     *
     * @return
     */
    List<Permission> selectAllPermission();

    /**
     * 添加权限
     *
     * @param permission
     * @return
     */
    int addPermission(Permission permission);

    /**
     * 更新权限
     *
     * @param permission
     * @return
     */
    int editPermission(Permission permission);

    /**
     * 删除权限
     *
     * @param id
     * @return
     */
    int deletePermission(Integer id);

    /**
     * 根据id查找权限
     *
     * @param id
     * @return
     */
    Permission findById(Integer id);

    /**
     * 查找出所有根权限
     *
     * @return
     */
    List<Permission> selectRootPermission();

    /**
     * 查找出所有子权限
     *
     * @return
     */
    List<Permission> selectChildPermission();
}

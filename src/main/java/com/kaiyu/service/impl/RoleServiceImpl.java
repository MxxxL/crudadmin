package com.kaiyu.service.impl;

import com.kaiyu.dao.RoleMapper;
import com.kaiyu.pojo.Permission;
import com.kaiyu.pojo.Role;
import com.kaiyu.pojo.RoleAndPermission;
import com.kaiyu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mxxxl
 * @date 2020/8/20
 * @description
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectAllRoles() {
        return roleMapper.selectAllRoles();
    }

    @Override
    public Role findById(Integer id) {
        return roleMapper.findById(id);
    }

    @Override
    public int addRole(Role role) {
        return roleMapper.addRole(role);
    }

    @Override
    public int editRole(Role role) {
        return roleMapper.editRole(role);
    }

    @Override
    public int deleteRole(Integer id) {
        return roleMapper.deleteRole(id);
    }

    @Override
    public int deleteRolePermission(Integer id) {
        return roleMapper.deleteRolePermission(id);
    }

    @Override
    public int deleteRolePermissionByRidAndPid(Integer rid, Integer pid) {
        return roleMapper.deleteRolePermissionByRidAndPid(rid, pid);
    }

    @Override
    public List<Integer> findPermissionIdByRoleId(Integer id) {
        return roleMapper.findPermissionIdByRoleId(id);
    }

    @Override
    public List<Permission> findPermissionByPid(List<Integer> listId) {
        return roleMapper.findPermissionByPid(listId);
    }

    @Override
    public int addRolePermission(RoleAndPermission roleAndPermission) {
        return roleMapper.addRolePermission(roleAndPermission);
    }

}

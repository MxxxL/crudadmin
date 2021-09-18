package com.kaiyu.service.impl;

import com.kaiyu.dao.PermissionMapper;
import com.kaiyu.pojo.Permission;
import com.kaiyu.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mxxxl
 * @date 2020/8/17
 * @description
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 生成权限list（包含子权限）
     *
     * @return
     */
    @Override
    public List<Permission> selectAllPermission() {
        List<Permission> permissions = permissionMapper.selectAllPermission();
        List<Permission> result = new ArrayList<>();
        for (Permission permission : permissions) {
            findChildPermission(permissions, permission);
            if (-1 == permission.getPid()) {
                result.add(permission);
            }
        }
        return result;
    }

    @Override
    public int addPermission(Permission permission) {
        return permissionMapper.addPermission(permission);
    }

    @Override
    public int editPermission(Permission permission) {
        return permissionMapper.editPermission(permission);
    }

    @Override
    public int deletePermission(Integer id) {
        return permissionMapper.deletePermission(id);
    }

    @Override
    public Permission findById(Integer id) {
        return permissionMapper.findById(id);
    }

    @Override
    public List<Permission> selectRootPermission() {
        return permissionMapper.selectRootPermission();
    }

    @Override
    public List<Permission> selectChildPermission() {
        return permissionMapper.selectChildPermission();
    }

    /**
     * 查找子权限
     *
     * @param permissions
     * @param parentPermission
     */
    private void findChildPermission(List<Permission> permissions, Permission parentPermission) {
        for (Permission permission : permissions) {
            if (permission.getPid().equals(parentPermission.getId())) {
                List<Permission> childPermissions = parentPermission.getChildPermission();
                if (childPermissions == null) {
                    childPermissions = new ArrayList<>();
                }

                if (!childPermissions.contains(permission)) {
                    childPermissions.add(permission);
                }

                parentPermission.setChildPermission(childPermissions);
            }
        }
    }
}

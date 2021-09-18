package com.kaiyu.dao;

import com.kaiyu.pojo.Permission;
import com.kaiyu.pojo.Role;
import com.kaiyu.pojo.RoleAndPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mxxxl
 * @date 2020/8/18
 * @description
 */
@Repository
public interface RoleMapper {

    /**
     * 查询所有角色
     *
     * @return
     */
    List<Role> selectAllRoles();

    /**
     * 根据Id查找角色
     *
     * @param id
     * @return
     */
    Role findById(Integer id);

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    int addRole(Role role);

    /**
     * 编辑角色
     *
     * @param role
     * @return
     */
    int editRole(Role role);

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    int deleteRole(Integer id);

    /**
     * 根据角色id删除该角色所有关联的权限
     *
     * @param id
     * @return
     */
    int deleteRolePermission(Integer id);

    /**
     * 根据角色id和权限id删除关联权限
     *
     * @param rid
     * @param pid
     * @return
     */
    int deleteRolePermissionByRidAndPid(@Param("rid") Integer rid, @Param("pid") Integer pid);

    /**
     * 根据角色id查找权限id
     *
     * @param id
     * @return
     */
    List<Integer> findPermissionIdByRoleId(Integer id);

    /**
     * 根据已经获取的权限id列表来获取权限
     *
     * @param listId
     * @return
     */
    List<Permission> findPermissionByPid(@Param("listId") List<Integer> listId);

    /**
     * 添加角色权限关联
     *
     * @param roleAndPermission
     * @return
     */
    int addRolePermission(RoleAndPermission roleAndPermission);
}

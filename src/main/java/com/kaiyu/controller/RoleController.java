package com.kaiyu.controller;

import com.kaiyu.pojo.Permission;
import com.kaiyu.pojo.Role;
import com.kaiyu.pojo.RoleAndPermission;
import com.kaiyu.service.PermissionService;
import com.kaiyu.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author mxxxl
 * @date 2020/8/20
 * @description
 */
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 角色管理首页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/roles")
    @RequiresPermissions("role:view")
    public String roleList(Model model) {
        List<Role> roles = roleService.selectAllRoles();
        model.addAttribute("roles", roles);
        return "roles/list";
    }

    /**
     * 添加角色页面
     *
     * @return
     */
    @RequestMapping(value = "/role")
    public String toAddPage() {
        return "roles/add";
    }

    /**
     * 添加操作
     *
     * @param role
     * @return
     */
    @PostMapping(value = "/role")
    public String add(Role role) {
        int result = roleService.addRole(role);
        if (result > 0) {
            // 添加信息后重定向
            return "redirect:/roles";
        } else {
            // 添加失败
            return "";
        }
    }

    /**
     * 角色编辑页面（查询单一权限）
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/role/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Role role = roleService.findById(id);
        model.addAttribute("role", role);

        return "roles/edit";
    }

    /**
     * 角色更新操作
     *
     * @param
     * @return
     */
    @PostMapping(value = "/updateRole")
    public String editPage(Role role) {
        int result = roleService.editRole(role);
        if (result > 0) {
            // 编辑信息后重定向至列表首页以观察信息变化
            return "redirect:/roles";
        } else {
            // 编辑失败
            return "";
        }
    }


    /**
     * 角色删除操作
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/deleteRole/{id}")
    public String delete(@PathVariable("id") Integer id) {
        int result = roleService.deleteRole(id);
        int result2 = roleService.deleteRolePermission(id);
        if (result > 0 && result2 > 0) {
            return "redirect:/roles";
        } else {
            // 删除失败
            return "";
        }
    }

    /**
     * 根据角色id跳转至该角色的权限列表
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/rolePermission/{id}")
    public String toPermissionPage(@PathVariable("id") Integer id, Model model) {
        Role role = roleService.findById(id);
        model.addAttribute("role", role);

        List<Integer> listId = roleService.findPermissionIdByRoleId(id);
        List<Permission> permissions = roleService.findPermissionByPid(listId);
        model.addAttribute("permissions", permissions);

        List<Permission> rootPermission = permissionService.selectRootPermission();
        model.addAttribute("rootPermission", rootPermission);

        return "roles/permissionList";
    }

    /**
     * 角色关联权限添加页面
     *
     * @return
     */
    @RequestMapping(value = "/roleAssociate/{id}")
    public String toPermissionAddPage(@PathVariable("id") Integer id, Model model) {
        Role role = roleService.findById(id);
        model.addAttribute("role", role);

        List<Permission> rootPermission = permissionService.selectRootPermission();
        List<Permission> childPermission = permissionService.selectChildPermission();
        rootPermission.addAll(childPermission);
        model.addAttribute("permissions", rootPermission);

        return "roles/rolePermissionAdd";
    }

    /**
     * 角色关联权限添加操作
     *
     * @param roleAndPermission
     * @return
     */
    @PostMapping(value = "/roleAssociate")
    public String addPermission(RoleAndPermission roleAndPermission) {

        int result = roleService.addRolePermission(roleAndPermission);
        if (result > 0) {
            return "redirect:/rolePermission/" + roleAndPermission.getRid();
        } else {
            return "";
        }
    }

    /**
     * 根据已知角色id和选中权限id删除关联权限
     *
     * @param rid
     * @param pid
     * @return
     */
    @GetMapping(value = "/deleteRolePermission/rid/{rid}/pid/{pid}")
    public String deleteRolePermission(@PathVariable("rid") Integer rid,
                                       @PathVariable("pid") Integer pid) {
        int result = roleService.deleteRolePermissionByRidAndPid(rid, pid);
        if (result > 0) {
            return "redirect:/rolePermission/" + rid;
        } else {
            return "";
        }
    }
}

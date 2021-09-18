package com.kaiyu.controller;

import com.kaiyu.pojo.Permission;
import com.kaiyu.service.PermissionService;
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
 * @date 2020/7/31
 * @description
 */
@Controller
public class AuthController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 权限管理首页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/auths")
    @RequiresPermissions("permission:view")
    public String authority(Model model) {
        List<Permission> rootPermission = permissionService.selectRootPermission();
        model.addAttribute("rootPermission", rootPermission);

        List<Permission> childPermission = permissionService.selectChildPermission();
        rootPermission.addAll(childPermission);
        model.addAttribute("permissions", rootPermission);
        return "auth/list";
    }

    /**
     * 添加权限页面
     *
     * @return
     */
    @RequestMapping(value = "/auth")
    public String toAddPage(Model model) {
        List<Permission> rootPermission = permissionService.selectRootPermission();
        model.addAttribute("rootPermission", rootPermission);
        return "auth/add";
    }

    /**
     * 添加操作
     *
     * @param permission
     * @return
     */
    @PostMapping(value = "/auth")
    public String add(Permission permission) {
        int result = permissionService.addPermission(permission);
        if (result > 0) {
            // 添加信息后重定向
            return "redirect:/auths";
        } else {
            // 添加失败
            return "";
        }
    }

    /**
     * 权限编辑页面（查询单一权限）
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/auth/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Permission permission = permissionService.findById(id);
        model.addAttribute("permission", permission);

        List<Permission> rootPermission = permissionService.selectRootPermission();
        model.addAttribute("rootPermission", rootPermission);
        return "auth/edit";
    }

    /**
     * 权限更新操作
     *
     * @param
     * @return
     */
    @PostMapping(value = "/updateAuth")
    public String editPage(Permission permission) {
        int result = permissionService.editPermission(permission);
        if (result > 0) {
            // 编辑信息后重定向至列表首页以观察信息变化
            return "redirect:/auths";
        } else {
            // 编辑失败
            return "";
        }
    }


    /**
     * 权限删除操作
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/deleteAuth/{id}")
    public String delete(@PathVariable("id") Integer id) {
        int result = permissionService.deletePermission(id);
        if (result > 0) {
            return "redirect:/auths";
        } else {
            // 删除失败
            return "";
        }
    }
}

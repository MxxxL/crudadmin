package com.kaiyu.controller;

import com.kaiyu.pojo.Role;
import com.kaiyu.pojo.User;
import com.kaiyu.pojo.UserAndRole;
import com.kaiyu.service.RoleService;
import com.kaiyu.service.UserService;
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
 * @date 2020/8/19
 * @description
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 用户管理首页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/users")
    @RequiresPermissions("user:view")
    public String authority(Model model) {
        List<User> users = userService.queryAll();
        model.addAttribute("users", users);
        return "users/list";
    }

    /**
     * 添加用户页面
     *
     * @return
     */
    @RequestMapping(value = "/user")
    public String toAddPage() {
        return "users/add";
    }

    /**
     * 添加操作
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/user")
    public String add(User user) {
        int result = userService.addUser(user);
        if (result > 0) {
            // 添加信息后重定向
            return "redirect:/users";
        } else {
            // 添加失败
            return "";
        }
    }

    /**
     * 用户编辑页面（查询单一用户）
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/user/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "users/edit";
    }

    /**
     * 用户更新操作
     *
     * @param
     * @return
     */
    @PostMapping(value = "/updateUser")
    public String editPage(User user) {
        int result = userService.editUser(user);
        if (result > 0) {
            // 编辑信息后重定向至列表首页以观察信息变化
            return "redirect:/users";
        } else {
            // 编辑失败
            return "";
        }
    }


    /**
     * 用户删除操作
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/deleteUser/{id}")
    public String delete(@PathVariable("id") Integer id) {
        int result = userService.deleteUser(id);
        int result2 = userService.deleteUserRoleByUid(id);
        if (result > 0 && result2 > 0) {
            return "redirect:/users";
        } else {
            // 删除失败
            return "";
        }
    }

    /**
     * 用户角色关联页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/userRole/{id}")
    public String toUserRolePage(@PathVariable("id") Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);

        List<Integer> rid = userService.findRoleIdByUserId(id);
        List<Role> roles = userService.findRoleByRid(rid);
        model.addAttribute("roles", roles);

        return "users/userRoleList";
    }

    /**
     * 用户角色关联添加页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/userAssociate/{id}")
    public String toAddUserRolePage(@PathVariable("id") Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);

        List<Role> roles = roleService.selectAllRoles();
        model.addAttribute("roles", roles);

        return "users/userRoleAdd";
    }

    /**
     * 用户角色关联添加操作
     *
     * @param userAndRole
     * @return
     */
    @PostMapping(value = "/userAssociate/")
    public String addUserRole(UserAndRole userAndRole) {
        int result = userService.addUserAndRole(userAndRole);
        if (result > 0) {
            return "redirect:/userRole/" + userAndRole.getUid();
        } else {
            return "";
        }
    }


    /**
     * 用户角色关联删除操作
     *
     * @param uid
     * @param rid
     * @return
     */
    @GetMapping(value = "/deleteUserAssociate/uid/{uid}/rid/{rid}")
    public String deleteUserAndRole(@PathVariable("uid") Integer uid,
                                    @PathVariable("rid") Integer rid) {
        int result = userService.deleteUserRoleByUidAndRid(uid, rid);
        if (result > 0) {
            return "redirect:/userRole/" + uid;
        } else {
            // 删除失败
            return "";
        }
    }
}

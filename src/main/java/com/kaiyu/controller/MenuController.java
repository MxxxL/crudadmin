package com.kaiyu.controller;

import com.kaiyu.pojo.Menu;
import com.kaiyu.service.MenuService;
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
 * @date 2020/8/17
 * @description
 */
@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 菜单管理首页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/menus")
    @RequiresPermissions("menu:view")
    public String menuList(Model model) {
        List<Menu> rootMenu = menuService.selectRootMenu();
        model.addAttribute("rootMenu", rootMenu);

        List<Menu> childMenu = menuService.selectChildMenu();
        rootMenu.addAll(childMenu);
        model.addAttribute("menus", rootMenu);
        return "menu/list";
    }

    /**
     * 添加菜单页面
     *
     * @return
     */
    @RequestMapping(value = "/menu")
    public String toAddPage(Model model) {
        List<Menu> rootMenu = menuService.selectRootMenu();
        model.addAttribute("rootMenu", rootMenu);
        return "menu/add";
    }

    /**
     * 添加操作
     *
     * @param menu
     * @return
     */
    @PostMapping(value = "/menu")
    public String add(Menu menu) {
        int result = menuService.addMenu(menu);
        if (result > 0) {
            // 添加信息后重定向
            return "redirect:/menus";
        } else {
            // 添加失败
            return "";
        }
    }

    /**
     * 菜单编辑页面（查询单一权限）
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/menu/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Menu menu = menuService.findById(id);
        model.addAttribute("menu", menu);

        List<Menu> rootMenu = menuService.selectRootMenu();
        model.addAttribute("rootMenu", rootMenu);
        return "menu/edit";
    }

    /**
     * 菜单更新操作
     *
     * @param
     * @return
     */
    @PostMapping(value = "/updateMenu")
    public String editPage(Menu menu) {
        int result = menuService.editMenu(menu);
        if (result > 0) {
            // 编辑信息后重定向至列表首页以观察信息变化
            return "redirect:/menus";
        } else {
            // 编辑失败
            return "";
        }
    }


    /**
     * 菜单删除操作
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/deleteMenu/{id}")
    public String delete(@PathVariable("id") Integer id) {
        int result = menuService.deleteMenu(id);
        if (result > 0) {
            return "redirect:/menus";
        } else {
            // 删除失败
            return "";
        }
    }

}

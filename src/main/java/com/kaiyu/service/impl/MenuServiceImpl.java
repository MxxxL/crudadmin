package com.kaiyu.service.impl;

import com.kaiyu.dao.MenuMapper;
import com.kaiyu.pojo.Menu;
import com.kaiyu.service.MenuService;
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
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 生成菜单List（包含子菜单）
     *
     * @return
     */
    @Override
    public List<Menu> selectAllMenu() {
        List<Menu> menus = menuMapper.selectAllMenu();
        List<Menu> result = new ArrayList<>();
        for (Menu menu : menus) {
            findChildMenu(menus, menu);
            if (-1 == menu.getPid()) {
                result.add(menu);
            }
        }
        return result;
    }

    @Override
    public List<Menu> selectRootMenu() {
        return menuMapper.selectRootMenu();
    }

    @Override
    public List<Menu> selectChildMenu() {
        return menuMapper.selectChildMenu();
    }

    @Override
    public int addMenu(Menu menu) {
        return menuMapper.addMenu(menu);
    }

    @Override
    public Menu findById(Integer id) {
        return menuMapper.findById(id);
    }

    @Override
    public int editMenu(Menu menu) {
        return menuMapper.editMenu(menu);
    }

    @Override
    public int deleteMenu(Integer id) {
        return menuMapper.deleteMenu(id);
    }

    /**
     * 查找子菜单
     *
     * @param menus
     * @param parentMenu
     */
    private void findChildMenu(List<Menu> menus, Menu parentMenu) {
        for (Menu menu : menus) {
            if (menu.getPid().equals(parentMenu.getId())) {
                List<Menu> childMenus = parentMenu.getChildMenu();
                if (childMenus == null) {
                    childMenus = new ArrayList<>();
                }

                if (!childMenus.contains(menu)) {
                    childMenus.add(menu);
                }

                parentMenu.setChildMenu(childMenus);
            }
        }
    }
}

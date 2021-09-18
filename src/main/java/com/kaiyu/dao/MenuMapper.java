package com.kaiyu.dao;

import com.kaiyu.pojo.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mxxxl
 * @date 2020/8/17
 * @description ：
 */
@Repository
public interface MenuMapper {

    /**
     * 查询所有菜单
     *
     * @return
     */
    List<Menu> selectAllMenu();

    /**
     * 查找根菜单
     *
     * @return
     */
    List<Menu> selectRootMenu();

    /**
     * 查找子菜单
     *
     * @return
     */
    List<Menu> selectChildMenu();

    /**
     * 添加菜单
     *
     * @param menu
     * @return
     */
    int addMenu(Menu menu);

    /**
     * 根据id查找菜单
     *
     * @param id
     * @return
     */
    Menu findById(Integer id);

    /**
     * 编辑菜单
     *
     * @param menu
     * @return
     */
    int editMenu(Menu menu);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    int deleteMenu(Integer id);
}

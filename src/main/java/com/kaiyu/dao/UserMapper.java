package com.kaiyu.dao;

import com.kaiyu.pojo.Role;
import com.kaiyu.pojo.User;
import com.kaiyu.pojo.UserAndRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mxxxl
 * @date 2020/7/21
 * @description
 */
@Repository
public interface UserMapper {


    /**
     * 根据名字查找用户
     *
     * @param username
     * @return
     */
    User findByName(String username);

    /**
     * 根据id查找用户
     *
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> queryAll();

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 编辑用户
     *
     * @param user
     * @return
     */
    int editUser(User user);

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    int deleteUser(Integer id);

    /**
     * 根据用户id查找角色id
     *
     * @param id
     * @return
     */
    List<Integer> findRoleIdByUserId(Integer id);

    /**
     * 根据已得到的角色id来查找角色
     *
     * @param listId
     * @return
     */
    List<Role> findRoleByRid(@Param("listId") List<Integer> listId);

    /**
     * 添加用户角色关联
     *
     * @param userAndRole
     * @return
     */
    int addUserAndRole(UserAndRole userAndRole);

    /**
     * 根据用户id和角色id删除关联
     *
     * @param uid
     * @param rid
     * @return
     */
    int deleteUserRoleByUidAndRid(@Param("uid") Integer uid, @Param("rid") Integer rid);

    /**
     * 删除该用户id下所有关联角色
     *
     * @param id
     * @return
     */
    int deleteUserRoleByUid(Integer id);
}

package com.kaiyu.service.impl;

import com.kaiyu.dao.UserMapper;
import com.kaiyu.pojo.Role;
import com.kaiyu.pojo.User;
import com.kaiyu.pojo.UserAndRole;
import com.kaiyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mxxxl
 * @date 2020/7/21
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int editUser(User user) {
        return userMapper.editUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public List<Integer> findRoleIdByUserId(Integer id) {
        return userMapper.findRoleIdByUserId(id);
    }

    @Override
    public List<Role> findRoleByRid(List<Integer> listId) {
        return userMapper.findRoleByRid(listId);
    }


    @Override
    public int addUserAndRole(UserAndRole userAndRole) {
        return userMapper.addUserAndRole(userAndRole);
    }

    @Override
    public int deleteUserRoleByUidAndRid(Integer uid, Integer rid) {
        return userMapper.deleteUserRoleByUidAndRid(uid, rid);
    }

    @Override
    public int deleteUserRoleByUid(Integer id) {
        return userMapper.deleteUserRoleByUid(id);
    }
}

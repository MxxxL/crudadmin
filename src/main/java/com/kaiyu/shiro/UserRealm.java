package com.kaiyu.shiro;

import com.kaiyu.pojo.ActiveUser;
import com.kaiyu.pojo.Permission;
import com.kaiyu.pojo.Role;
import com.kaiyu.pojo.User;
import com.kaiyu.service.PermissionService;
import com.kaiyu.service.RoleService;
import com.kaiyu.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mxxxl
 * @date 2020/7/28
 * @description
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 执行授权逻辑
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 给资源授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        ActiveUser activeUser = (ActiveUser) principalCollection.getPrimaryPrincipal();
        User user = activeUser.getUser();
        List<String> superPermission = new ArrayList<>();
        superPermission.add("*:*");
        List<String> permissions = activeUser.getPermissions();
        List<String> correct =
                permissions.stream().filter(item -> item != null).collect(Collectors.toList());


        List<Integer> roleIds = userService.findRoleIdByUserId(user.getId());
        List<Role> roles = userService.findRoleByRid(roleIds);

        for (Role role : roles) {
            if ("超级管理员".equals(role.getName())) {
                info.addStringPermissions(superPermission);
            } else {
                if (permissions.size() > 0) {
                    info.addStringPermissions(correct);
                }
            }
        }
        return info;
    }

    /**
     * 执行认证逻辑
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 编写shiro判断逻辑，判断用户名和密码
        // 1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        User user = userService.findByName(token.getUsername());

        if (user != null) {
            //活动用户
            ActiveUser activeUser = new ActiveUser();
            activeUser.setUser(user);
            //根据id查找角色id
            Integer userId = user.getId();
            List<Integer> roleId = userService.findRoleIdByUserId(userId);

            //根据角色id查找权限id
            List<Integer> pid = new ArrayList<>();
            for (Integer rid :
                    roleId) {
                List<Integer> permissionId = roleService.findPermissionIdByRoleId(rid);
                pid.addAll(permissionId);
            }
            //根据权限id查找权限
            List<Permission> permissions = new ArrayList<>();
            if (pid.size() > 0) {
                permissions = roleService.findPermissionByPid(pid);
            }

            List<String> percodes = new ArrayList<>();
            for (Permission permission : permissions) {
                percodes.add(permission.getPercode());
            }
            //添加至活动用户
            activeUser.setPermissions(percodes);

            // 2.判断密码
            return new SimpleAuthenticationInfo(activeUser, user.getPassword(), null,
                    this.getName());
        } else {
            return null;
        }


    }
}

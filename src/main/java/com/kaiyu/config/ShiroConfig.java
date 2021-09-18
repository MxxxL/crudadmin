package com.kaiyu.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.kaiyu.shiro.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author mxxxl
 * @date 2020/7/28
 * @description shiro配置类
 */
@Configuration
public class ShiroConfig {


    /**
     * 创建ShiroFilterFactoryBean
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 添加Shiro内置过滤器
        /*
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *      常用的过滤器：
         *              anon: 无需认证就可以访问
         *              authc: 必须认证才可以访问
         *              user:  如果使用rememberMe的功能可以直接访问
         *              perms: 该资源必须得到资源权限才可以访问
         *              role:  该资源必须得到角色权限才可以访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();

        // 设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");
        // 登录页面
        shiroFilterFactoryBean.setLoginUrl("/");
        // 放行
        filterMap.put("/css/**", "anon");
        filterMap.put("/js/**", "anon");
        filterMap.put("/img/**", "anon");
        filterMap.put("/user/login", "anon");
        filterMap.put("/user/logout", "anon");
        filterMap.put("/index.html", "anon");
        filterMap.put("/", "anon");

        // 授权过滤
        // 部门
        filterMap.put("/emps", "perms[dept:view]");
        filterMap.put("/emp", "perms[dept:create]");
        filterMap.put("/emp/*", "perms[dept:update]");
        filterMap.put("/updateEmp", "perms[dept:update]");
        filterMap.put("/deleteEmp/*", "perms[dept:delete]");
        // 菜单
        filterMap.put("/menus", "perms[menu:view]");
        filterMap.put("/menu", "perms[menu:create]");
        filterMap.put("/menu/*", "perms[menu:update]");
        filterMap.put("/updateMenu", "perms[menu:update]");
        filterMap.put("/deleteMenu/*", "perms[menu:delete]");
        // 权限
        filterMap.put("/auths", "perms[permission:view]");
        filterMap.put("/auth", "perms[permission:create]");
        filterMap.put("/auth/*", "perms[permission:update]");
        filterMap.put("/updateAuth", "perms[permission:update]");
        filterMap.put("/deleteAuth/*", "perms[permission:delete]");
        // 角色
        filterMap.put("/roles", "perms[role:view]");
        filterMap.put("/role", "perms[role:create]");
        filterMap.put("/role/*", "perms[role:update]");
        filterMap.put("/updateRole", "perms[role:update]");
        filterMap.put("/deleteRole/*", "perms[role:delete]");
        filterMap.put("/rolePermission/*", "perms[role:selectPermission]");
        filterMap.put("/roleAssociate/*", "perms[role:selectPermission]");
        filterMap.put("/deleteRolePermission/*", "perms[role:selectPermission]");

        // 用户
        filterMap.put("/users", "perms[user:view]");
        filterMap.put("/user", "perms[user:create]");
        filterMap.put("/user/*", "perms[user:update]");
        filterMap.put("/updateUser", "perms[user:update]");
        filterMap.put("/deleteUser/*", "perms[user:delete]");
        filterMap.put("/userRole/*", "perms[user:selectRole]");
        filterMap.put("/userAssociate/*", "perms[user:selectRole]");
        filterMap.put("/deleteUserAssociate/*", "perms[user:selectRole]");

        // 拦截
        filterMap.put("/**", "authc");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     *
     * @param userRealm
     * @return
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor =
                new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator =
                new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 创建Realm
     *
     * @return
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }

    /**
     * 配置ShiroDialect，用于thymeleaf和shiro标签配合使用
     *
     * @return
     */
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}

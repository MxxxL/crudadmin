/*
 Navicat Premium Data Transfer

 Source Server         : kaiyu
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : db_springboot

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 20/08/2020 16:21:14
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_department
-- ----------------------------
DROP TABLE IF EXISTS `tb_department`;
CREATE TABLE `tb_department`
(
    `id`              int(0) NOT NULL,
    `department_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_ci NOT NULL COMMENT '部门名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_as_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_department
-- ----------------------------
INSERT INTO `tb_department`
VALUES (101, '教学部');
INSERT INTO `tb_department`
VALUES (102, '市场部');
INSERT INTO `tb_department`
VALUES (103, '人事部');
INSERT INTO `tb_department`
VALUES (104, '运营部');
INSERT INTO `tb_department`
VALUES (105, '后勤部');

-- ----------------------------
-- Table structure for tb_employee
-- ----------------------------
DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE `tb_employee`
(
    `id`            int(0) NOT NULL AUTO_INCREMENT,
    `employee_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_ci NOT NULL COMMENT '员工姓名',
    `email`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_ci NOT NULL COMMENT '员工邮箱',
    `gender`        int(0) NOT NULL COMMENT '员工性别',
    `department_id` int(0) NOT NULL COMMENT '部门编号',
    `date`          date                                                          NOT NULL COMMENT '入职日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1014 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_as_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_employee
-- ----------------------------
INSERT INTO `tb_employee`
VALUES (1001, '张三', 'zhangsan@gmail.com', 0, 101, '2020-02-12');
INSERT INTO `tb_employee`
VALUES (1002, '李四', 'lisi@qq.com', 1, 102, '2020-02-05');
INSERT INTO `tb_employee`
VALUES (1003, '王五', 'wangwu@126.com', 0, 103, '2020-02-15');
INSERT INTO `tb_employee`
VALUES (1004, '赵六', 'zhaoliu@163.com', 1, 104, '2020-02-21');
INSERT INTO `tb_employee`
VALUES (1005, '田七', 'tianqi@foxmail.com', 0, 105, '2020-02-14');
INSERT INTO `tb_employee`
VALUES (1006, '王伟', 'wangwei@gmail.com', 1, 103, '2020-02-08');
INSERT INTO `tb_employee`
VALUES (1007, '张伟', 'zhangwei@gmail.com', 1, 102, '2020-02-11');
INSERT INTO `tb_employee`
VALUES (1008, '李伟', 'liwei@gmail.com', 1, 101, '2020-02-18');
INSERT INTO `tb_employee`
VALUES (1009, 'test', 'xxx@xxx.com', 1, 101, '2020-07-22');
INSERT INTO `tb_employee`
VALUES (1010, '开瑜', 'kaiyu1203@foxmail.com', 1, 105, '2020-07-21');
INSERT INTO `tb_employee`
VALUES (1011, '测试', 'ceshi@ceshi.com', 1, 101, '2019-12-31');
INSERT INTO `tb_employee`
VALUES (1012, 'test2', 'ceshi@ceshi.com', 1, 102, '2020-01-01');
INSERT INTO `tb_employee`
VALUES (1013, 'test3', 'ceshi@ceshi.com', 0, 105, '2020-01-01');
INSERT INTO `tb_employee`
VALUES (1014, 'test4', 'ceshi@ceshi.com', 0, 101, '2020-01-01');

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu`
(
    `id`    int(0) NOT NULL AUTO_INCREMENT,
    `pid`   int(0) NULL DEFAULT NULL COMMENT '子菜单',
    `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单标题',
    `url`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单路径',
    `order` int(0) NULL DEFAULT NULL COMMENT '排序',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu`
VALUES (1, -1, '后台管理系统', '', 1);
INSERT INTO `tb_menu`
VALUES (2, -1, '基础管理', NULL, 2);
INSERT INTO `tb_menu`
VALUES (3, -1, '业务管理', NULL, 3);
INSERT INTO `tb_menu`
VALUES (4, -1, '系统管理', NULL, 4);
INSERT INTO `tb_menu`
VALUES (5, -1, '其他管理', NULL, 5);
INSERT INTO `tb_menu`
VALUES (6, 2, '公告管理', NULL, 6);
INSERT INTO `tb_menu`
VALUES (7, 3, '供应商管理', NULL, 7);
INSERT INTO `tb_menu`
VALUES (8, 3, '商品管理', NULL, 8);
INSERT INTO `tb_menu`
VALUES (9, 3, '客户管理', '', 9);
INSERT INTO `tb_menu`
VALUES (10, 4, '部门管理', '/emps', 10);
INSERT INTO `tb_menu`
VALUES (11, 4, '菜单管理', '/menus', 11);
INSERT INTO `tb_menu`
VALUES (12, 4, '权限管理', '/auths', 12);
INSERT INTO `tb_menu`
VALUES (13, 4, '角色管理', '/roles', 13);
INSERT INTO `tb_menu`
VALUES (14, 4, '用户管理', '/users', 14);

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission`
(
    `id`      int(0) NOT NULL AUTO_INCREMENT,
    `pid`     int(0) NULL DEFAULT NULL COMMENT '子权限',
    `name`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限名称',
    `percode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限编码',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_permission
-- ----------------------------
INSERT INTO `tb_permission`
VALUES (1, -1, '部门管理', NULL);
INSERT INTO `tb_permission`
VALUES (2, -1, '菜单管理', NULL);
INSERT INTO `tb_permission`
VALUES (3, -1, '权限管理', NULL);
INSERT INTO `tb_permission`
VALUES (4, -1, '角色管理', NULL);
INSERT INTO `tb_permission`
VALUES (5, -1, '用户管理', NULL);
INSERT INTO `tb_permission`
VALUES (6, 1, '添加部门', 'dept:create');
INSERT INTO `tb_permission`
VALUES (7, 1, '修改部门', 'dept:update');
INSERT INTO `tb_permission`
VALUES (8, 1, '删除部门', 'dept:delete');
INSERT INTO `tb_permission`
VALUES (9, 2, '添加菜单', 'menu:create');
INSERT INTO `tb_permission`
VALUES (10, 2, '修改菜单', 'menu:update');
INSERT INTO `tb_permission`
VALUES (11, 2, '删除菜单', 'menu:delete');
INSERT INTO `tb_permission`
VALUES (12, 3, '添加权限', 'permission:create');
INSERT INTO `tb_permission`
VALUES (13, 3, '修改权限', 'permission:update');
INSERT INTO `tb_permission`
VALUES (14, 3, '删除权限', 'permission:delete');
INSERT INTO `tb_permission`
VALUES (15, 4, '添加角色', 'role:create');
INSERT INTO `tb_permission`
VALUES (16, 4, '修改角色', 'role:update');
INSERT INTO `tb_permission`
VALUES (17, 4, '删除角色', 'role:delete');
INSERT INTO `tb_permission`
VALUES (18, 4, '分配权限', 'role:selectPermission');
INSERT INTO `tb_permission`
VALUES (19, 5, '添加用户', 'user:create');
INSERT INTO `tb_permission`
VALUES (20, 5, '修改用户', 'user:update');
INSERT INTO `tb_permission`
VALUES (21, 5, '删除用户', 'user:delete');
INSERT INTO `tb_permission`
VALUES (22, 5, '分配角色', 'user:selectRole');
INSERT INTO `tb_permission`
VALUES (23, 5, '重置密码', 'user:resetPwd');
INSERT INTO `tb_permission`
VALUES (24, 1, '部门查询', 'dept:view');
INSERT INTO `tb_permission`
VALUES (25, 2, '菜单查询', 'menu:view');
INSERT INTO `tb_permission`
VALUES (26, 3, '权限查询', 'permission:view');
INSERT INTO `tb_permission`
VALUES (27, 4, '角色查询', 'role:view');
INSERT INTO `tb_permission`
VALUES (28, 5, '用户查询', 'user:view');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`
(
    `id`   int(0) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role`
VALUES (1, '超级管理员');
INSERT INTO `tb_role`
VALUES (2, '基础管理员');
INSERT INTO `tb_role`
VALUES (3, '业务管理员');
INSERT INTO `tb_role`
VALUES (4, '系统管理员');
INSERT INTO `tb_role`
VALUES (5, '其他管理员');
INSERT INTO `tb_role`
VALUES (6, '测试');

-- ----------------------------
-- Table structure for tb_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_permission`;
CREATE TABLE `tb_role_permission`
(
    `rid` int(0) NOT NULL COMMENT '角色id',
    `pid` int(0) NOT NULL COMMENT '权限id',
    PRIMARY KEY (`rid`, `pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role_permission
-- ----------------------------
INSERT INTO `tb_role_permission`
VALUES (1, 1);
INSERT INTO `tb_role_permission`
VALUES (1, 2);
INSERT INTO `tb_role_permission`
VALUES (1, 3);
INSERT INTO `tb_role_permission`
VALUES (1, 4);
INSERT INTO `tb_role_permission`
VALUES (1, 5);
INSERT INTO `tb_role_permission`
VALUES (1, 6);
INSERT INTO `tb_role_permission`
VALUES (1, 7);
INSERT INTO `tb_role_permission`
VALUES (1, 8);
INSERT INTO `tb_role_permission`
VALUES (1, 9);
INSERT INTO `tb_role_permission`
VALUES (1, 10);
INSERT INTO `tb_role_permission`
VALUES (1, 11);
INSERT INTO `tb_role_permission`
VALUES (1, 12);
INSERT INTO `tb_role_permission`
VALUES (1, 13);
INSERT INTO `tb_role_permission`
VALUES (1, 14);
INSERT INTO `tb_role_permission`
VALUES (1, 15);
INSERT INTO `tb_role_permission`
VALUES (1, 16);
INSERT INTO `tb_role_permission`
VALUES (1, 17);
INSERT INTO `tb_role_permission`
VALUES (1, 18);
INSERT INTO `tb_role_permission`
VALUES (1, 19);
INSERT INTO `tb_role_permission`
VALUES (1, 20);
INSERT INTO `tb_role_permission`
VALUES (1, 21);
INSERT INTO `tb_role_permission`
VALUES (1, 22);
INSERT INTO `tb_role_permission`
VALUES (1, 23);
INSERT INTO `tb_role_permission`
VALUES (1, 24);
INSERT INTO `tb_role_permission`
VALUES (1, 25);
INSERT INTO `tb_role_permission`
VALUES (1, 26);
INSERT INTO `tb_role_permission`
VALUES (1, 27);
INSERT INTO `tb_role_permission`
VALUES (1, 28);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`
(
    `id`       int(0) NOT NULL AUTO_INCREMENT,
    `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_ci NOT NULL COMMENT '用户名',
    `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_ci NOT NULL COMMENT '密码',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_as_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user`
VALUES (1, 'admin', '123456');
INSERT INTO `tb_user`
VALUES (2, 'zky', 'zky');
INSERT INTO `tb_user`
VALUES (13, 'abc', '123456');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role`
(
    `uid` int(0) NOT NULL COMMENT '用户id',
    `rid` int(0) NOT NULL COMMENT '角色id',
    PRIMARY KEY (`uid`, `rid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role`
VALUES (1, 1);
INSERT INTO `tb_user_role`
VALUES (2, 6);
INSERT INTO `tb_user_role`
VALUES (13, 4);

SET
FOREIGN_KEY_CHECKS = 1;

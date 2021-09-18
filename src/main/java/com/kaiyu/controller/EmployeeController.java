package com.kaiyu.controller;

import com.kaiyu.pojo.Department;
import com.kaiyu.pojo.Employee;
import com.kaiyu.service.DepartmentService;
import com.kaiyu.service.EmployeeService;
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
 * @date 2020/7/21
 * @description
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    /**
     * 员工管理首页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/emps")
    @RequiresPermissions("dept:view")
    public String list(Model model) {
        List<Employee> employees = employeeService.queryAll();
        List<Department> departments = departmentService.queryAll();
        model.addAttribute("departments", departments);
        model.addAttribute("emps", employees);
        // 返回员工管理列表页
        return "emp/list";
    }

    /**
     * 导向员工信息添加页
     *
     * @param model
     * @return
     */
    @GetMapping(value = "/emp")
    public String toAddPage(Model model) {
        // 查出所有部门的信息
        List<Department> departments = departmentService.queryAll();
        model.addAttribute("departments", departments);
        // 返回员工管理添加页
        return "emp/add";
    }

    /**
     * 员工管理添加页添加操作
     *
     * @param employee
     * @return
     */
    @PostMapping(value = "/emp")
    public String addPage(Employee employee) {
        // 添加操作 调用业务方法保存员工信息
        int result = employeeService.insertOneEmployee(employee);
        if (result > 0) {
            // 添加信息后重定向至列表首页以观察信息变化
            return "redirect:/emps";
        } else {
            // 添加失败
            return "";
        }

    }

    /**
     * 员工信息编辑页面（查询单一员工）
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeService.getEmpById(id);
        List<Department> departments = departmentService.queryAll();
        model.addAttribute("emp", employee);
        model.addAttribute("departments", departments);
        return "emp/edit";
    }

    /**
     * 员工信息更新操作
     *
     * @param employee
     * @return
     */
    @PostMapping(value = "/updateEmp")
    public String editPage(Employee employee) {

        int result = employeeService.updateOneEmployee(employee);
        if (result > 0) {
            // 编辑信息后重定向至列表首页以观察信息变化
            return "redirect:/emps";
        } else {
            // 编辑失败
            return "";
        }
    }

    /**
     * 删除员工操作
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/deleteEmp/{id}")
    public String delete(@PathVariable("id") Integer id) {
        int result = employeeService.deleteOneEmployee(id);
        if (result > 0) {
            return "redirect:/emps";
        } else {
            // 删除失败
            return "";
        }
    }
}

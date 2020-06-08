package com.hpuswl.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hpuswl.ssm.entity.Employee;
import com.hpuswl.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emps")
    public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Map<String, Object> map){
        PageHelper.startPage(pn, 5);
        List<Employee> list = employeeService.getAll();
        PageInfo<Employee> pageInfo = new PageInfo<>(list, 5);
        map.put("pageInfo", pageInfo);
        return "list";
    }
}

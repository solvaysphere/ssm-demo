package com.hpuswl.ssm.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.hpuswl.ssm.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ServiceTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testSaveEmployee(){
        Employee employee = new Employee();
        employee.setLastName("MybatisPlus Generator");
        employee.setEmail("aaa@solvay.com");
        employeeService.insert(employee);
    }

    @Test
    public void testPageEmployee(){

        Page<Employee> page = employeeService.selectPage(new Page<Employee>(1, 3));

        System.out.println(page);
    }

    @Test
    public void testSqlExplain() {
        employeeService.delete(null);
    }

    @Test
    public void testOptimisticLocker() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("Tom");
        employee.setEmail("tmaa@solvay.com");
        employee.setAge(22);
        employee.setGender("1");
        employee.setVersion(1);
        employeeService.updateById(employee);
    }
}

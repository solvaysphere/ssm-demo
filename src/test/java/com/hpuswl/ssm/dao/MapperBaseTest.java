package com.hpuswl.ssm.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.hpuswl.ssm.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperBaseTest {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testInsertEmp(){
        Employee employee = new Employee();
        employee.setLastName("Solvay333");
        employee.setEmail("solvay333@lanternfish.cn");
        employee.setAge(15);
        employee.setGender(1);
        System.out.println(employee);
        Integer result = employeeMapper.insert(employee);
        System.out.println("结果：" + result);
        System.out.println(employee);
    }

    @Test
    public void testUpdateEmp(){
        Employee employee = new Employee();
        employee.setId(5);
        employee.setLastName("SolvayDD");
        employee.setEmail("solvaydd@lanternfish.cn");
        employee.setAge(15);
        employee.setGender(2);
        Integer result = employeeMapper.updateById(employee);
        System.out.println("结果：" + result);
    }

    @Test
    public void testUpdateAllColumnEmp(){
        Employee employee = new Employee();
        employee.setId(5);
        employee.setLastName("SolvayDD");
        employee.setGender(2);
        Integer result = employeeMapper.updateAllColumnById(employee);
        System.out.println("结果：" + result);
    }

    @Test
    public void testSelectEmp() {
        /*Employee employee = employeeMapper.selectById(1);
        System.out.println(employee);*/
        List<Employee> employees = employeeMapper.selectPage(new Page<Employee>(2, 2), null);
        employees.stream().forEach(System.out::println);
    }

    @Test
    public void testDeleteEmp() {
        Integer result = employeeMapper.deleteById(5);
        System.out.println("结果：" + result);
    }
}

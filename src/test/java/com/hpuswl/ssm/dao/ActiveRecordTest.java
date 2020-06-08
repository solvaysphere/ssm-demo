package com.hpuswl.ssm.dao;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hpuswl.ssm.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ActiveRecordTest {

    @Test
    public void testARInsert(){
        Employee employee = new Employee();
        employee.setLastName("MybatisPlus12");
        employee.setEmail("mybatisplus12@solvay.com");
        employee.setGender(1);
        employee.setAge(22);
        boolean b = employee.insert();
        System.out.println("执行插入：" + b);

        System.out.println(employee);
    }

    @Test
    public void testARUpdate(){
        Employee employee = new Employee();
        employee.setId(10);
        employee.setLastName("MybatisPlus18");
        employee.setEmail("mybatisplus12@solvay.com");
        employee.setGender(1);
        employee.setAge(22);
        boolean b = employee.updateById();
        System.out.println("执行更新：" + b);

        System.out.println(employee);
    }

    @Test
    public void testARSelect(){
        Employee employee = new Employee();
        employee.setId(10);
        Employee emp = employee.selectById();
        System.out.println(emp);
    }

    @Test
    public void testARPage(){
        Employee employee = new Employee();
        Page<Employee> page = employee.selectPage(new Page<Employee>(1, 2),
                new EntityWrapper<Employee>()
                        .like("last_name", "MybatisPlus"));
        System.out.println(page.getRecords());
    }

}

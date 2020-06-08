package com.hpuswl.ssm.dao;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
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
public class MapperWrapperTest {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testPageWrapper(){
        List<Employee> list = employeeMapper.selectPage(new Page<Employee>(2,3),
                new EntityWrapper<Employee>()
                        .eq("last_name", "MybatisPlus")
                        .eq("gender", 1)
                        .between("age", 18, 50));
        list.stream().forEach(System.out::println);
    }

    @Test
    public void testPageCondition(){
        List<Employee> list = employeeMapper.selectPage(new Page<Employee>(2,3),
                Condition.create()
                        .eq("last_name", "MybatisPlus")
                        .eq("gender", 1)
                        .between("age", 18, 50));
        list.stream().forEach(System.out::println);
    }

}

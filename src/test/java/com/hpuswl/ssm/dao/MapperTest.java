package com.hpuswl.ssm.dao;

import com.hpuswl.ssm.entity.Department;
import com.hpuswl.ssm.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    @Test
    public void testDepartmentMapper() {
        Department department = new Department();
        department.setDeptName("开发部");
        departmentMapper.insertSelective(department);
        department = new Department();
        department.setDeptName("测试部");
        departmentMapper.insertSelective(department);
    }

    @Test
    public void testEmployeeMapper() {
        /*Employee employee = new Employee();
        employee.setEmpName("admin");
        employee.setEmail("admin@solvay.com");
        employee.setGender("M");
        employee.setdId(1);
        employeeMapper.insertSelective(employee);*/
        //批量插入员工信息
        EmployeeMapper mapper = sqlSessionTemplate.getMapper(EmployeeMapper.class);
        for(int i = 0; i < 1000; i++){
            Employee employee = new Employee();
            String uuid = UUID.randomUUID().toString().substring(0, 5) + i;
            employee.setEmpName(uuid);
            employee.setEmail(uuid + "@solvay.com");
            employee.setGender("M");
            employee.setdId(1);
            mapper.insertSelective(employee);
        }
    }
}

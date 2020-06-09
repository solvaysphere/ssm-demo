package com.hpuswl.ssm.service.impl;

import com.hpuswl.ssm.entity.Employee;
import com.hpuswl.ssm.dao.EmployeeMapper;
import com.hpuswl.ssm.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author solvay
 * @since 2020-06-08
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}

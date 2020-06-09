package com.hpuswl.ssm.service.impl;

import com.hpuswl.ssm.entity.User;
import com.hpuswl.ssm.dao.UserMapper;
import com.hpuswl.ssm.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

package com.hpuswl.ssm.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hpuswl.ssm.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class LogicSqlInjectorTest {
    @Autowired
    private UserService userService;

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUserName("MybatisPlus2");
        user.setLogicFlag(1);
        userService.insert(user);
        System.out.println(user);
    }

    @Test
    public void testSelectUser() {
        List<User> userList = userService.selectList(new EntityWrapper<User>().eq("user_name", "MybatisPlus"));
        System.out.println(userList);
    }

    @Test
    public void testDeleteUser() {
//        boolean result = userService.deleteById(1);
//		System.out.println("result:" +result );

        User user = userService.selectById(1);
        System.out.println(user);
    }
}

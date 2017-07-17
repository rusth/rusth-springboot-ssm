package cn.rusth.controller;

import cn.rusth.dao.UserDao;
import cn.rusth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基础实现，springmvc基本功能
 * Created by rusth on 2017/6/14.
 * 测试基础控制器
 */
@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/baseTest")
    public User baseTest() {
        //调用dao层
        User user = userDao.selectByPrimaryKey(1);
        return user;
    }

}

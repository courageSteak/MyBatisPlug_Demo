/*
 * @Author  : 有勇气的牛排（全网同名）
 * @FileName: TestConttroller.java
 * desc     :
 * */

package com.couragesteak.controller;

import com.couragesteak.mapper.UserMapper;
import com.couragesteak.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

    // http://127.0.0.1:8080/test
    @RequestMapping("/test")
    public String testSelectList(){

        // 通过条件构造器，查询一个list集合，若没有条件，则可以设置null为参数
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);

        return "666";
    }

}

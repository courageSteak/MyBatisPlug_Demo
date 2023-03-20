/*
 * @Author  : 有勇气的牛排（全网同名）
 * @FileName: MyBatisPlusEnumTest.java
 * desc     :
 * */

package com.couragesteak;

import com.couragesteak.enums.SexEnum;
import com.couragesteak.mapper.UserMapper;
import com.couragesteak.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusEnumTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {

        User user = new User();
        user.setName("admin");
        user.setAge(20);
        //设置性别信息为枚举项，会将@EnumValue注解所标识的属性值存储到数据库
        user.setSex(SexEnum.MALE);

        int result = userMapper.insert(user);
        System.out.println("result: " + result);
    }

}

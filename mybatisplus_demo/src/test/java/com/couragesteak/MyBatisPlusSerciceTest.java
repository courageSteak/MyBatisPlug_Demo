/*
 * @Author  : 有勇气的牛排（全网同名）
 * @FileName: MyBatisPlusSerciceTest.java
 * desc     :
 * */

package com.couragesteak;

import com.couragesteak.pojo.User;
import com.couragesteak.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class MyBatisPlusSerciceTest {

    @Autowired  // 自动装配注解
    private UserService userService;

    @Test
    public void testGetCount() {
        // 查询总记录数
        // SELECT COUNT( * ) FROM user
        long count = userService.count();
        System.out.println("总记录数：" + count);
    }

    @Test
    public void testInsertMore() {
        // 批量添加：单个sql语句循环添加
        // INSERT INTO user ( id, name, age ) VALUES ( ?, ?, ? )
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            User user = new User();
            user.setName("有勇气的牛排" + i);
            user.setAge(18 + i);
            list.add(user);
        }

        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }


}

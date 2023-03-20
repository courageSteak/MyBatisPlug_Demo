/*
 * @Author  : 有勇气的牛排（全网同名）
 * @FileName: MyBatisPlusTest.java
 * desc     :
 * */

package com.couragesteak;

import com.couragesteak.mapper.UserMapper;
import com.couragesteak.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class MyBatisPlusMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        System.out.println("666");
        // 通过条件构造器，查询一个list集合，若没有条件，则可以设置null为参数
List<User> list = userMapper.selectList(null);
list.forEach(System.out::println);

    }

    @Test
    public void testInsert() {
        User user = new User();
        // user.setId(6);
        user.setName("有勇气的牛排6");
        user.setAge(18);
        user.setEmail("test6@couragesteak.com");

        int result = userMapper.insert(user);
        System.out.println(result);

        System.out.println("result: " + result);
        System.out.println("result: " + user.getId());

    }

    @Test
    public void testDelete() {
        // 通过id删除用户信息
        // DELETE FROM user WHERE id=?
        /*int result = userMapper.deleteById(1637055722611748866L);
        System.out.println("result: " + result);*/

        // 根据map集合中所设置的条件删除用户信息
        /*Map<String, Object> map = new HashMap<>();
        map.put("name", "有勇气的牛排5");
        map.put("age", 22);

        int result = userMapper.deleteByMap(map);
        System.out.println("result: " + result);*/


        // 通过多个id实现批量删除
        // DELETE FROM user WHERE id IN ( ? , ? , ? )
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println("result: " + result);
    }

    @Test
    public void testUpdate() {

        // 修改用户信息
        // UPDATE user SET name=?, email=? WHERE id=?
        User user = new User();
        user.setId(8L);
        user.setName("牛排哥");
        user.setEmail("test1@couragesteak.com");

        int result = userMapper.updateById(user);
        System.out.println("result: " + result);
    }

    @Test
    public void testSelect() {
        // 通过id查询用户信息
        // SELECT id,name,age,email FROM user WHERE id=?
       /* User user = userMapper.selectById(1L);
        System.out.println(user);*/

        // 根据多个id查询多个用户信息
        // SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
        /*List<Long> list = Arrays.asList(1L, 2L, 3L);
        List<User> users = userMapper.selectBatchIds(list);
        users.forEach(System.out::println);*/


        // 根据map集合中的条件查询用户信息
        // SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        /*Map<String, Object> map = new HashMap<>();
        map.put("name", "牛排哥");
        map.put("age", 18);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);*/

        // 查询所有数据
        // SELECT id,name,age,email FROM user
//        List<User> users = userMapper.selectList(null);
//        users.forEach(System.out::println);

        // 自定义查询方法
        Map<String, Object> map = userMapper.selectByMapId(1L);
        System.out.println(map);

    }


}

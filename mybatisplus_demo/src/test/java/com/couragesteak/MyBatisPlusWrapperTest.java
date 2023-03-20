/*
 * @Author  : 有勇气的牛排（全网同名）
 * @FileName: MyBatisPlusWrapperTest.java
 * desc     :
 * */

package com.couragesteak;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.couragesteak.mapper.UserMapper;
import com.couragesteak.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        // 查询用户名包含9，年龄在18~20，邮箱部位null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("u_name", "9")    // (字段名, 值)
                .between("age", 18, 22)
                .isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void testOrder() {
        // 查询用户信息，按照年龄降序，若年龄相同，则按照id升序排序
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                .orderByAsc("id");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void testDelete() {
        // 删除邮箱地址为null的用户信息
        // UPDATE c_user SET is_deleted=1 WHERE is_deleted=0 AND (email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper);
        System.out.println("result：" + result);
    }


    @Test
    public void testUpdateOr() {
        // 将 (age>20 且 u_name 包含9) 或 email=null 的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 18)
                .like("u_name", "9")
                .or()
                .isNull("email");

        User user = new User();
        user.setName("牛排哥");

        int result = userMapper.update(user, queryWrapper);
        System.out.println("result: " + result);
    }

    @Test
    public void testUpdateAnd() {
        // 将 u_name包含9，且（age>18 或 email=null）的用户信息修改
        // UPDATE c_user SET u_name=? WHERE is_deleted=0 AND (u_name LIKE ? AND (age > ? OR email IS NULL))
        // lambda中的条件优先执行
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("u_name", "9")
                .and(i -> i.gt("age", 18).or().isNull("email"));

        User user = new User();
        user.setName("有勇气的牛排博客");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("result: " + result);
    }

    @Test
    public void testSelect() {

        // 查询 用户名、年龄、邮箱
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("u_name", "age", "email");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void testSub() {
        // 查询 id<=3 的用户信息
        // SELECT id,u_name AS name,age,email,is_deleted FROM c_user WHERE is_deleted=0 AND (id IN (select id from c_user where id <= 3))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id", "select id from c_user where id <= 3");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void testUpdateWrapper() {
        // 将 u_name包含9，且（age>18 或 email=null）的用户信息修改
        // UPDATE c_user SET u_name=?,email=? WHERE is_deleted=0 AND (u_name LIKE ? AND (age > ? OR email IS NULL))
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        // 条件
        updateWrapper.like("u_name", "9")
                .and(i -> i.gt("age", 18).or().isNull("email"));
        // 修改(相对于QueryWrapper，这里不在创建实体类对象)
        updateWrapper.set("u_name", "牛排哥")
                .set("email", "my@couragesteak.com");
        int result = userMapper.update(null, updateWrapper);
        System.out.println("result: " + result);
    }

    @Test
    public void testUpdateWrapper2() {
        String username = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // com.baomidou.mybatisplus.core.toolkit.StringUtils;
        if (StringUtils.isNotBlank(username)) {
            // 判断某个字符串是否不为空、不为null、不为空白符
            queryWrapper.like("u_name", username);
        }

        if (ageBegin != null) {
            queryWrapper.ge("age", 18);  // ge 表示 >=
        }

        if (ageEnd != null) {
            queryWrapper.le("age", 18);  // le 表示 <=
        }

        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void testWrapper02() {
        String username = "9";
        Integer ageBegin = 18;
        Integer ageEnd = 30;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), "u_name", username)
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);

        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);

    }

    @Test
    public void testLambdaQueryWrapper() {
        String username = "9";
        Integer ageBegin = 18;
        Integer ageEnd = 30;

        // LambdaQueryWrapper<泛型为：实体类类型>
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), User::getName, username)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);

        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void testLambdaUpdateWrapper() {
        // UPDATE c_user SET u_name=?,email=? WHERE is_deleted=0 AND (u_name LIKE ? AND (age > ? OR email IS NULL))
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        // 条件
        updateWrapper.like(User::getName, "9")
                .and(i -> i.gt(User::getAge, 18).or().isNull(User::getEmail));
        // 修改(相对于QueryWrapper，这里不在创建实体类对象)
        updateWrapper.set(User::getName, "牛排哥").set(User::getEmail, "my@couragesteak.com");
        int result = userMapper.update(null, updateWrapper);
        System.out.println("result: " + result);
    }

}

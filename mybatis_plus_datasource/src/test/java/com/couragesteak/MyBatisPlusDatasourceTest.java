/*
 * @Author  : 有勇气的牛排（全网同名）
 * @FileName: MyBatisPlusDatasourceTest.java
 * desc     :
 * */

package com.couragesteak;

import com.couragesteak.service.ProductService;
import com.couragesteak.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusDatasourceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Test
    public void test(){
        System.out.println(userService.getById(1));
        System.out.println(productService.getById(1));
    }


}

/*
 * @Author  : 有勇气的牛排（全网同名）
 * @FileName: MyBatisPlusPluginsTest.java
 * desc     : MyBatisPlus 插件
 * */

package com.couragesteak;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.couragesteak.mapper.ProductMapper;
import com.couragesteak.mapper.UserMapper;
import com.couragesteak.pojo.Product;
import com.couragesteak.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusPluginsTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testPage() {
        // SELECT id,u_name AS name,age,email,is_deleted FROM c_user WHERE is_deleted=0 LIMIT ?,?

        Page<User> page = new Page<>(2, 3);
        userMapper.selectPage(page, null);

        System.out.println(page);
        System.out.println("======");
        System.out.println(page.getRecords());
        System.out.println("当前页面: " + page.getCurrent());        // 当前页面
        System.out.println("当前 查询 记录数: " + page.getSize());           // 查询 记录数
        System.out.println("总页数: " + page.getPages());            // 总页数
        System.out.println("获取总记录数: " + page.getTotal());       // 获取总记录数
        System.out.println("是否有下一页: " + page.hasNext());        // 是否有下一页
        System.out.println("是否有上一页: " + page.hasPrevious());    // 是否有上一页
    }

    @Test
    public void testPageVo() {
        Page<User> page = new Page<>(1, 3);
        // 查 age> 20 的，并且分页
        userMapper.selectPageVo(page, 20);

        System.out.println(page);
        System.out.println("======");
        System.out.println(page.getRecords());
        System.out.println("当前页面: " + page.getCurrent());        // 当前页面
        System.out.println("当前 查询 记录数: " + page.getSize());           // 查询 记录数
        System.out.println("总页数: " + page.getPages());            // 总页数
        System.out.println("获取总记录数: " + page.getTotal());       // 获取总记录数
        System.out.println("是否有下一页: " + page.hasNext());        // 是否有下一页
        System.out.println("是否有上一页: " + page.hasPrevious());    // 是否有上一页

    }

    @Test
    public void testProduct() {
// 小李 查询 商品价格
Product product_li = productMapper.selectById(1);
// 小王 查询 商品价格
Product product_w = productMapper.selectById(1);


System.out.println("小李查询的商品价格：" + product_li.getPrice());
// 小李查询的商品价格: 2000
System.out.println("小李查询的商品价格：" + product_w.getPrice());
// 小王查询的商品价格: 2000

// 小李将商品价格 +50
product_li.setPrice(product_li.getPrice() + 50);
productMapper.updateById(product_li);

// 小王将商品价格 -30
product_w.setPrice(product_w.getPrice() - 30);
int result = productMapper.updateById(product_w);
if (result==0){
    // 操作失败，重试
    Product productNew = productMapper.selectById(1);
    productNew.setPrice(productNew.getPrice()-30);
    productMapper.updateById(productNew);
}


// 老板查询商品价格
Product product_boss = productMapper.selectById(1);
System.out.println("老板查询的商品价格：" + product_boss.getPrice());
// 老板查询的商品价格：70


    }


}

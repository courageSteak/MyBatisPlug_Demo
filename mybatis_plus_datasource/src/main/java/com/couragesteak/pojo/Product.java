/*
 * @Author  : 有勇气的牛排（全网同名）
 * @FileName: Product.java
 * desc     :
 * */

package com.couragesteak.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("c_product")
public class Product {

    private Integer id;

    private String name;

    private Integer price;

    private Integer version;

}

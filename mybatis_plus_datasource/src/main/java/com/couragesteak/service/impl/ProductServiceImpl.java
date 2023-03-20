/*
 * @Author  : 有勇气的牛排（全网同名）
 * @FileName: ProductServiceImpl.java
 * desc     :
 * */

package com.couragesteak.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.couragesteak.mapper.ProductMapper;
import com.couragesteak.mapper.UserMapper;
import com.couragesteak.pojo.Product;
import com.couragesteak.service.ProductService;
import org.springframework.stereotype.Service;

@Service
@DS("slave_1")  //指定所操作的数据源
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}

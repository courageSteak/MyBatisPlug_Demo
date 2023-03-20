package com.couragesteak.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.couragesteak.pojo.Product;
import com.couragesteak.service.ProductService;
import com.couragesteak.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【c_product】的数据库操作Service实现
* @createDate 2023-03-20 21:21:10
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}





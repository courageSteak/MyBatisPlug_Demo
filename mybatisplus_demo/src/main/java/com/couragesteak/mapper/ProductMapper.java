package com.couragesteak.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.couragesteak.pojo.Product;
import org.springframework.stereotype.Repository;

// BaseMapper<泛型：实体类>
@Repository     // 持久化
public interface ProductMapper extends BaseMapper<Product> {
}

package com.couragesteak.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.couragesteak.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【c_product】的数据库操作Mapper
* @createDate 2023-03-20 21:21:10
* @Entity com.couragesteak.pojo.Product
*/
public interface ProductMapper extends BaseMapper<Product> {

    int insertSelective(Product product);

    int deleteByIdAndName(@Param("id") Long id, @Param("name") String name);



}





package com.couragesteak.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.couragesteak.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;


// 继承 MyBatis-Plus的 BaseMapper<泛型>
@Repository // 将接口标识为持久层组件
public interface UserMapper extends BaseMapper<User> {

    /**
     * 自定义查询: 根据id查询用户信息为map集合
     * 映射文件: classpath: mapper/UserMapper.xml
     *
     * @param id
     * @return
     */
    Map<String, Object> selectByMapId(Long id);

    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);

}

/*
 * @Author  : 有勇气的牛排（全网同名）
 * @FileName: UserServiceImpl.java
 * desc     : Service实现类
 * */

package com.couragesteak.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.couragesteak.mapper.UserMapper;
import com.couragesteak.pojo.User;
import com.couragesteak.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 1. 继承 ServiceImpl<M:当前接口类型, T:当前实体类型>
 * 2. 实现自己的接口 UserSercice
 */

@Service    // 将Sercice标记为组件
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

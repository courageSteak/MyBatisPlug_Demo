/*
 * @Author  : 有勇气的牛排（全网同名）
 * @FileName: UserServiceImpl.java
 * desc     :
 * */

package com.couragesteak.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.couragesteak.mapper.UserMapper;
import com.couragesteak.pojo.User;
import com.couragesteak.service.UserService;
import org.springframework.stereotype.Service;

@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

/*
 * @Author  : 有勇气的牛排（全网同名）
 * @FileName: User.java
 * desc     :
 * */


package com.couragesteak.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;

@Data
@TableName("c_user")
public class User {

    @TableId
    private Integer id;

    private String uName;

    private Integer age;

    private String email;

    @TableLogic
    private Integer isDeleted;

    private Integer sex;



}

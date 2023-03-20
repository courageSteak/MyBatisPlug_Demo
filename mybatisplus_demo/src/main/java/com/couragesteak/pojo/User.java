/*
 * @Author  : 有勇气的牛排（全网同名）
 * @FileName: User.java
 * desc     :
 * */

package com.couragesteak.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.couragesteak.enums.SexEnum;
import lombok.*;


//@NoArgsConstructor  // 无参构造
//@AllArgsConstructor // 所有参数 有参构造
//@Getter             // 添加getter方法
//@Setter             // 添加setter方法
@Data   // 代替以上所有注解
@TableName("c_user")    // 设置实体类对应的表名
public class User {
//    @TableId(value = "id", type = IdType.AUTO)

    // @TableId的value属性，用于设置主键的字段
    // @TableId的type属性，用于设置主键生成策略
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    // 指定属性所对应的字段名
    @TableField("u_name")
    private String name;

    private Integer age;
    private String email;

    @EnumValue  // 将注解所标识属性的值存储到数据库中
    private SexEnum sex;

    @TableLogic
    private Integer isDeleted;
}

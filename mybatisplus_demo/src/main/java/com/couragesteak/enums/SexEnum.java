package com.couragesteak.enums;

import lombok.Getter;

@Getter
public enum SexEnum {

    MALE(1,"男"),
    FEMALE(2,"女");

    private Integer sex;
    private String sexName;

    // 创建构造器
    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}

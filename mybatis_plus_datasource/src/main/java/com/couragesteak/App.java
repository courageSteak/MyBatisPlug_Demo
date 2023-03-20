/*
 * @Author  : 有勇气的牛排（全网同名）
 * @FileName: App.java
 * desc     :
 * */

package com.couragesteak;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
// 扫描指定包下的 mapper 接口
@MapperScan("com.couragesteak.mapper")    // 迁移到配置类
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        log.info("项目启动成功");
    }
}

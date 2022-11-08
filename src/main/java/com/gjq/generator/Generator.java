package com.gjq.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;

import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class Generator {

    private static String url="jdbc:mysql://localhost:3307/seckill?serverTimezone=Asia/Shanghai";
    private static String username="root";
    private static String password="123456";

    public static void main(String[] args) {
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("gjq") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\file\\github_project\\skilldemo\\master\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.gjq.generator") // 设置父包名
                            .service("service")
                            .entity("pojo")
                            .mapper("mapper")
                            .serviceImpl("service.Impl")
                            .controller("controller")
//                            .moduleName("springboot") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\file\\springboot\\plrk\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}

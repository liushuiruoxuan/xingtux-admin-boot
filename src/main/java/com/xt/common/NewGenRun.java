package com.xt.common;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.sql.Types;
import java.util.*;

/**
 * 代码生成
 * 注意： 请先修改resources目录下的generator.properties文件中的配置，无误则执行当前类下的main方法
 *
 * @author gzc
 * @since 2022/10/1 11:09
 **/
public class NewGenRun {

    /**
     * 代码生成入口
     * 注意： 请先修改resources目录下的generator.properties文件中的配置
     */
    public static void main(String[] args) {
        doGenerator();
        getPath();
    }

    private static Properties properties = new Properties();

    static {
        // 读取resources目录下的配置文件
        InputStream inputStream = NewGenRun.class.getClassLoader().getResourceAsStream("generator.properties");
        try {
            properties.load(IoUtil.getReader(inputStream, Charset.defaultCharset()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 代码生成实现
     * 提示：如果不需要生成controller相关代码，设置packageConfig中的controller为""，设置templateConfig中的controller为null
     */
    private static void doGenerator() {
        // 建立数据库连接
        String url = properties.getProperty("database.url");
        String username = properties.getProperty("database.username");
        String password = properties.getProperty("database.password");

        // 模块名称
        String moduleName = properties.getProperty("moduleName");
        // 项目目录
        String projectPath = properties.getProperty("projectPath");
        String javaPath = projectPath + moduleName + "/src/main/java/";
        String resourcesPath = projectPath + moduleName + "/src/main/resources/";
        String mapperPath = properties.getProperty("mapperPath");
        // 作者名称
        String author = properties.getProperty("author");
        // 基础包路径
        String packagePath = properties.getProperty("packagePath");
        int lastIndexOf = packagePath.lastIndexOf(StrUtil.DOT);
        String chaiPackagePath = packagePath.substring(0, lastIndexOf);
        int lastIndexOf2 = chaiPackagePath.lastIndexOf(StrUtil.DOT);
        String commonPackagePath = packagePath.substring(0, lastIndexOf2);
        String replacePackagePath = packagePath.replace(StrUtil.DOT, StrUtil.SLASH);

        // 需要生成的表
        String tables = properties.getProperty("tables");
        String tablePrefix = properties.getProperty("tablePrefix");
        // 代码生成后是否打开磁盘目录
        // 全局配置
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author(author) // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(javaPath) // 指定输出目录
                            .dateType(DateType.ONLY_DATE)
                            .disableOpenDir()
                    ;
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.TINYINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }

                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder -> {
                    Map<OutputFile, String> outputFileStringMap = new HashMap<>();
                    // 设置mapperXml生成路径
                    outputFileStringMap.put(OutputFile.xml, resourcesPath + mapperPath);
                    // 设置dto生成路径
                    builder.parent(packagePath) // 设置父包名
                            .moduleName(moduleName) // 设置父包模块名
                            .entity("domain.entity") // 设置实体类包名
                            .pathInfo(outputFileStringMap)
                    ;

                })
                .strategyConfig(builder -> {
                            String entity = "/templates/domain/entity/entity.java";
                            String mapper = "/templates/mapper/mapper.java";
                            String mapperXml = "/templates/mapper/mapper.xml";
                            String service = "/templates/service/service.java";
                            String serviceImpl = "/templates/service/serviceImpl/serviceImpl.java";
                            String controller = "/templates/controller/controller.java";
                            builder.addInclude(tables) // 设置需要生成的表名
                                    .addTablePrefix(tablePrefix) // 设置过滤表前缀
                                    .entityBuilder().javaTemplate(entity).enableLombok()
                                    .mapperBuilder().mapperTemplate(mapper).mapperXmlTemplate(mapperXml)
                                    .serviceBuilder().serviceTemplate(service).serviceImplTemplate(serviceImpl)
                                    .controllerBuilder().template(controller).enableFileOverride();

                        }

                ).injectionConfig(builder -> {
                    List<CustomFile> customFiles = new ArrayList<>();
                    customFiles.add(new CustomFile.Builder().fileName("Request.java").templatePath("/templates/controller/request/request.java.ftl").filePath(javaPath + replacePackagePath+"/controller/request").enableFileOverride().build());
                    customFiles.add(new CustomFile.Builder().fileName("Response.java").templatePath("/templates/controller/response/response.java.ftl").filePath(javaPath + replacePackagePath+"/controller/response").enableFileOverride().build());
                    customFiles.add(new CustomFile.Builder().fileName("DTO.java").templatePath("/templates/domain/dto/dto.java.ftl").filePath(javaPath + replacePackagePath+"/domain/dto").enableFileOverride().build());
                    Map<String,Object > map = new HashMap<>();
                    map.put("commonPackagePath",commonPackagePath);
                    builder.customMap(map);
                    builder.customFile(customFiles);
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }


    /**
     * 获取当前项目本地磁盘目录
     */
    private static void getPath() {
        System.out.println("当前项目本地磁盘目录->" + System.getProperty("user.dir"));
    }

}


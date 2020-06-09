package com.hpuswl.ssm;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class GeneratorCodeTest {

    /**
     * 代码生成 示例代码
     */
    @Test
    public void testGenerator() {
        //全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true) //是否支持AR模式
                .setAuthor("solvay") //作者
                .setOutputDir("/Users/lanternfish/WorkSpace/SpringCode/github/ssm-crm/src/main/java") //生成路径
                .setFileOverride(true) //文件覆盖
                .setEnableCache(false) // XML 二级缓存
                .setBaseResultMap(true) // XML ResultMap
                .setBaseColumnList(true) // XML columList
                .setServiceName("%sService") //设置生成的service接口名,默认首字母为I
                .setIdType(IdType.AUTO); //主键策略
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        //.setMapperName("%sDao")
        //.setXmlName("%sDao")
        //.setServiceName("MP%sService")
        //.setServiceImplName("%sServiceDiy")
        //.setControllerName("%sAction")

        //数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL) //设置数据库类型
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://134.134.2.70:33061/mp")
                .setUsername("root")
                .setPassword("123456");

        //策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) //全局大写命名
                .setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
                .setTablePrefix("tb_") // 此处可以修改为您的表前缀
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setInclude("tb_user");  // 生成的表

        //包名策略
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.hpuswl.ssm")
                .setController("controller")
                .setEntity("entity")
                .setMapper("dao")
                .setService("service")
                .setXml("mappers");

        //整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);

        //执行
        ag.execute();
    }
}


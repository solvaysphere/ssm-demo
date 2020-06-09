# ssm-crm
Spring4整合Mybatis-Plus

```xml
<!-- Mybatis-plus:
  特别说明：Mybatis及Mybatis-Spring依赖请勿加入项目配置，以免引起版本冲突！！！
  Mybatis-Plus会自动帮你维护！
  -->
<dependency>
  <groupId>com.baomidou</groupId>
  <artifactId>mybatis-plus</artifactId>
  <version>2.3.3</version>
</dependency>
```

### 版本说明
1. Spring: 4.3.27.RELEASE
2. Mybatis-Plus: 2.3.3
3. Mysql: 5.1.49
4. C3P0: 0.9.5.5

### Mybatis-Plus代码生成器配置
```xml
<!-- 模板引擎 -->
<dependency>
    <groupId>org.apache.velocity</groupId>
    <artifactId>velocity-engine-core</artifactId>
    <version>2.1</version>
</dependency>
```
加入 slf4j ,查看日志输出信息
```xml
<!-- 日志依赖包 -->
<dependency>
  <groupId>log4j</groupId>
  <artifactId>log4j</artifactId>
  <version>1.2.17</version>
</dependency>
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-api</artifactId>
  <version>1.7.30</version>
</dependency>
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-log4j12</artifactId>
  <version>1.7.30</version>
</dependency>
```
[代码生成器示例代码](https://baomidou.gitee.io/mybatis-plus-doc/#/generate-code)

### 插件扩展
分页插件 ： com.baomidou.mybatisplus.plugins.PaginationInterceptor
执行分析插件： com.baomidou.mybatisplus.plugins.SqlExplainInterceptor
性能分析插件： com.baomidou.mybatisplus.plugins.PerformanceInterceptor
乐观锁插件: com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor
```xml
<!--整合Mybatis-Plus配置-->
<bean id="sqlSessionFactory" class="com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean">
    <property name="configLocation" value="classpath:mybatis-config.xml" />
    <property name="dataSource" ref="dataSource" />
    <property name="mapperLocations" value="classpath:/mappers/*.xml" />
    <!-- Mybatis Plus全局配置 -->
    <property name="globalConfig" ref="globalConfig"></property>
    <!-- Mybatis Plus插件配置 -->
    <property name="plugins">
        <array>
            <!-- 分页插件配置 -->
            <bean id="paginationInterceptor"
                  class="com.baomidou.mybatisplus.plugins.PaginationInterceptor"/>
            <!-- 执行分析配置 -->
            <bean id="sqlExplainInterceptor"
                  class="com.baomidou.mybatisplus.plugins.SqlExplainInterceptor">
                <property name="stopProceed" value="true" />
            </bean>
            <!-- 乐观锁插件 -->
            <bean id="optimisticLockerInterceptor"
                  class="com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor">
            </bean>
            <!-- 性能拦截器，兼打印sql，不建议生产环境配置-->
            <bean id="performanceInterceptor"
                  class="com.baomidou.mybatisplus.plugins.PerformanceInterceptor">
                <property name="format" value="true" />
                <!--<property name="maxTime" value="5" />-->
            </bean>
        </array>
    </property>
</bean>
```
### [Mybatis-Plus逻辑删除配置](https://baomidou.gitee.io/mybatis-plus-doc/#/logic-delete)
```xml
<bean id="globalConfig" class="com.baomidou.mybatisplus.entity.GlobalConfiguration">
    <property name="sqlInjector" ref="logicSqlInjector" />
    <property name="logicDeleteValue" value="-1" />
    <property name="logicNotDeleteValue" value="1" />
    <property name="idType" value="2" />
</bean>
<bean id="logicSqlInjector" class="com.baomidou.mybatisplus.mapper.LogicSqlInjector" />
```
逻辑删除实体
```java
@TableName("tbl_user")
public class UserLogicDelete {

    private Long id;
    ...
    @TableField(value = "delete_flag")
    @TableLogic
    private Integer deleteFlag;
}
```
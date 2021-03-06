# simple-springmvc-app
simple-springmvc-app

### spring扩展开发

* 写自己的`<mysource:annotation-driven/>`,见`META-INF/mysource.xsd`
* 写自己的namespacehandler,见`MysourceNamespaceHandler`
* 写`AnnotationDrivenBeanDefinitionParser`注册相应的处理器
* 写`AutowiredAnnotationBeanPostProcessor`处理依赖注入

### logback日志集成

> 加入依赖,要注意版本

```xml
<!--logback日志-->
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.3</version>
</dependency>
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-core</artifactId>
    <version>1.2.3</version>
</dependency>
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-access</artifactId>
    <version>1.2.3</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.25</version>
</dependency>
<!--logback日志-->
```

> 配置logback.xml

```xml
<?xml version="1.0" encoding="utf-8"?>

<!--
debug=true可以打印日志系统状态
scan=true可以自动扫描配置文件的变化并加载
packagingData=true可以打印堆栈异常错误信息
-->
<configuration debug="true" scan="true" scanPeriod="30 seconds" packagingData="true" >

    <!--定义变量 scope=context变量生效范围-->
    <property scope="context" name="LOG_PATH" value="."/>
    <!--当变量定义很多时，可以提出到文件中，在这里引入
    <property file="src/main/java/chapters/configuration/variables1.properties" />
    在classpath时可以这样引入
    <property resource="resource1.properties" />
    -->

    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <!-- encoders are assigned the type
             ch.qos.logback.classic.encoder.PatternLayoutEncoder by default -->
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <appender name="FILE" class="ch.qos.logback.core.FileAppender">
        <!--使用变量-->
        <file>${LOG_PATH}/myApp.log</file>
        <encoder>
            <pattern>%date %level [%thread] %logger{100} [%file:%line] %msg%n</pattern>
        </encoder>
    </appender>

    <appender name="ROLLING" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_PATH}/myLog.txt</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <!-- rollover daily -->
            <fileNamePattern>myLog-%d{yyyy-MM-dd}.%i.txt</fileNamePattern>
            <!-- each file should be at most 100MB, keep 60 days worth of history, but at most 20GB -->
            <maxFileSize>1KB</maxFileSize>
            <maxHistory>60</maxHistory>
            <totalSizeCap>20GB</totalSizeCap>
        </rollingPolicy>
        <encoder>
            <pattern>%date %level [%thread] %logger{100} [%file:%line] %msg%n</pattern>
        </encoder>
    </appender>

    <logger name="com.ibingbo.logback" level="INFO"/>
    <!--additivity="false"表示该日志只打印到指定的地方appender，即不重复打印-->
    <logger name="com.ibingbo.logback.bean.User" level="DEBUG" additivity="false">
        <appender-ref ref="FILE"/>
    </logger>

    <root level="DEBUG">
        <appender-ref ref="STDOUT" />
        <appender-ref ref="FILE"/>
        <appender-ref ref="ROLLING"/>
    </root>
</configuration>
```

> 直接应用

```java
Logger logger = LoggerFactory.getLogger(BeanTest.class);
logger.debug("hello,logback");
```

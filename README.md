# 《Spring Boot 编程思想 》学习笔记
> [小马哥《Spring Boot 编程思想 》](https://github.com/mercyblitz/thinking-in-spring-boot-samples)

## 第一章 初览 Spring Boot

## 第二章 理解独立的 Spring 应用

### 2.2 运行 Spring Boot 应用
> idea 启动  
> mvn spring-boot:run   

#### 2.2.1 执行 java -jar
```java -jar target/chapter2-1.0-SNAPSHOT.jar```

依赖：
```$xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
```

#### 2.2.2 Spring Boot 可执行 JAR 资源结构
```$xslt

root@kali:/opt/Codes/xmg-spring-boot-samples/chapter2# tree target/ -h 
target/
├── [ 16M]  chapter2-1.0-SNAPSHOT.jar
├── [2.8K]  chapter2-1.0-SNAPSHOT.jar.original
├── [4.0K]  classes
│   └── [4.0K]  xmg
│       └── [4.0K]  spring
│           └── [4.0K]  boot
│               └── [4.0K]  samples
│                   └── [4.0K]  chapter2
│                       └── [ 817]  FirstAppByGuiApplication.class
├── [4.0K]  generated-sources
│   └── [4.0K]  annotations
├── [4.0K]  generated-test-sources
│   └── [4.0K]  test-annotations
├── [4.0K]  maven-archiver
│   └── [  73]  pom.properties
├── [4.0K]  maven-status
│   └── [4.0K]  maven-compiler-plugin
│       ├── [4.0K]  compile
│       │   └── [4.0K]  default-compile
│       │       ├── [  64]  createdFiles.lst
│       │       └── [ 121]  inputFiles.lst
│       └── [4.0K]  testCompile
│           └── [4.0K]  default-testCompile
│               ├── [   0]  createdFiles.lst
│               └── [   0]  inputFiles.lst
└── [4.0K]  test-classes

18 directories, 8 files

```
对比没有添加 spring-boot-maven-plugin 插件的结构：
```$xslt
root@kali:/opt/Codes/xmg-spring-boot-samples/chapter2# tree target/ -h 
target/
├── [2.7K]  chapter2-1.0-SNAPSHOT.jar
├── [4.0K]  classes
│   └── [4.0K]  xmg
│       └── [4.0K]  spring
│           └── [4.0K]  boot
│               └── [4.0K]  samples
│                   └── [4.0K]  chapter2
│                       └── [ 817]  FirstAppByGuiApplication.class
├── [4.0K]  generated-sources
│   └── [4.0K]  annotations
├── [4.0K]  generated-test-sources
│   └── [4.0K]  test-annotations
├── [4.0K]  maven-archiver
│   └── [  73]  pom.properties
├── [4.0K]  maven-status
│   └── [4.0K]  maven-compiler-plugin
│       ├── [4.0K]  compile
│       │   └── [4.0K]  default-compile
│       │       ├── [  64]  createdFiles.lst
│       │       └── [ 121]  inputFiles.lst
│       └── [4.0K]  testCompile
│           └── [4.0K]  default-testCompile
│               ├── [   0]  createdFiles.lst
│               └── [   0]  inputFiles.lst
└── [4.0K]  test-classes

18 directories, 7 files

```
发现：
chapter2-1.0-SNAPSHOT.jar 变大了，因为包含了依赖的 JAR

新的 JAR 解压：
```$xslt
root@kali:/tmp/jar02# tree . -h 
.
├── [4.0K]  BOOT-INF
│   ├── [4.0K]  classes
│   │   └── [4.0K]  xmg
│   │       └── [4.0K]  spring
│   │           └── [4.0K]  boot
│   │               └── [4.0K]  samples
│   │                   └── [4.0K]  chapter2
│   │                       └── [ 817]  FirstAppByGuiApplication.class
│   └── [4.0K]  lib
│       ├── [ 65K]  classmate-1.4.0.jar
│       ├── [1.1M]  hibernate-validator-6.0.16.Final.jar
│       ├── [ 65K]  jackson-annotations-2.9.0.jar
│       ├── [318K]  jackson-core-2.9.8.jar
│       ├── [1.3M]  jackson-databind-2.9.8.jar
│       ├── [ 33K]  jackson-datatype-jdk8-2.9.8.jar
│       ├── [ 98K]  jackson-datatype-jsr310-2.9.8.jar
│       ├── [8.4K]  jackson-module-parameter-names-2.9.8.jar
│       ├── [ 26K]  javax.annotation-api-1.3.2.jar
│       ├── [ 65K]  jboss-logging-3.3.2.Final.jar
│       ├── [4.5K]  jul-to-slf4j-1.7.26.jar
│       ├── [260K]  log4j-api-2.11.2.jar
│       ├── [ 17K]  log4j-to-slf4j-2.11.2.jar
│       ├── [284K]  logback-classic-1.2.3.jar
│       ├── [461K]  logback-core-1.2.3.jar
│       ├── [ 40K]  slf4j-api-1.7.26.jar
│       ├── [294K]  snakeyaml-1.23.jar
│       ├── [360K]  spring-aop-5.1.7.RELEASE.jar
│       ├── [658K]  spring-beans-5.1.7.RELEASE.jar
│       ├── [931K]  spring-boot-2.1.5.RELEASE.jar
│       ├── [1.2M]  spring-boot-autoconfigure-2.1.5.RELEASE.jar
│       ├── [ 397]  spring-boot-starter-2.1.5.RELEASE.jar
│       ├── [ 403]  spring-boot-starter-json-2.1.5.RELEASE.jar
│       ├── [ 406]  spring-boot-starter-logging-2.1.5.RELEASE.jar
│       ├── [ 404]  spring-boot-starter-tomcat-2.1.5.RELEASE.jar
│       ├── [ 403]  spring-boot-starter-web-2.1.5.RELEASE.jar
│       ├── [193K]  spring-boot-test-2.1.5.RELEASE.jar
│       ├── [1.1M]  spring-context-5.1.7.RELEASE.jar
│       ├── [1.2M]  spring-core-5.1.7.RELEASE.jar
│       ├── [274K]  spring-expression-5.1.7.RELEASE.jar
│       ├── [ 23K]  spring-jcl-5.1.7.RELEASE.jar
│       ├── [1.3M]  spring-web-5.1.7.RELEASE.jar
│       ├── [782K]  spring-webmvc-5.1.7.RELEASE.jar
│       ├── [3.2M]  tomcat-embed-core-9.0.19.jar
│       ├── [244K]  tomcat-embed-el-9.0.19.jar
│       ├── [259K]  tomcat-embed-websocket-9.0.19.jar
│       └── [ 91K]  validation-api-2.0.1.Final.jar
├── [ 16M]  chapter2-1.0-SNAPSHOT.jar
├── [4.0K]  META-INF
│   ├── [ 387]  MANIFEST.MF
│   └── [4.0K]  maven
│       └── [4.0K]  xmg.spring.boot.samples
│           └── [4.0K]  chapter2
│               ├── [  73]  pom.properties
│               └── [1.2K]  pom.xml
└── [4.0K]  org
    └── [4.0K]  springframework
        └── [4.0K]  boot
            └── [4.0K]  loader
                ├── [4.0K]  archive
                │   ├── [ 302]  Archive$Entry.class
                │   ├── [ 437]  Archive$EntryFilter.class
                │   ├── [ 945]  Archive.class
                │   ├── [ 273]  ExplodedArchive$1.class
                │   ├── [1.1K]  ExplodedArchive$FileEntry.class
                │   ├── [1.5K]  ExplodedArchive$FileEntryIterator$EntryComparator.class
                │   ├── [3.7K]  ExplodedArchive$FileEntryIterator.class
                │   ├── [5.1K]  ExplodedArchive.class
                │   ├── [1.7K]  JarFileArchive$EntryIterator.class
                │   ├── [1.1K]  JarFileArchive$JarFileEntry.class
                │   └── [7.2K]  JarFileArchive.class
                ├── [4.0K]  data
                │   ├── [ 485]  RandomAccessData.class
                │   ├── [ 282]  RandomAccessDataFile$1.class
                │   ├── [2.6K]  RandomAccessDataFile$DataInputStream.class
                │   ├── [3.2K]  RandomAccessDataFile$FileAccess.class
                │   └── [3.9K]  RandomAccessDataFile.class
                ├── [3.5K]  ExecutableArchiveLauncher.class
                ├── [4.0K]  jar
                │   ├── [4.9K]  AsciiBytes.class
                │   ├── [ 616]  Bytes.class
                │   ├── [3.0K]  CentralDirectoryEndRecord.class
                │   ├── [5.1K]  CentralDirectoryFileHeader.class
                │   ├── [4.5K]  CentralDirectoryParser.class
                │   ├── [ 540]  CentralDirectoryVisitor.class
                │   ├── [ 345]  FileHeader.class
                │   ├── [ 11K]  Handler.class
                │   ├── [3.6K]  JarEntry.class
                │   ├── [ 299]  JarEntryFilter.class
                │   ├── [2.0K]  JarFile$1.class
                │   ├── [1.2K]  JarFile$2.class
                │   ├── [1.3K]  JarFile$JarFileType.class
                │   ├── [ 15K]  JarFile.class
                │   ├── [1.6K]  JarFileEntries$1.class
                │   ├── [2.0K]  JarFileEntries$EntryIterator.class
                │   ├── [ 14K]  JarFileEntries.class
                │   ├── [ 702]  JarURLConnection$1.class
                │   ├── [4.2K]  JarURLConnection$JarEntryName.class
                │   ├── [9.6K]  JarURLConnection.class
                │   ├── [3.6K]  StringSequence.class
                │   └── [1.8K]  ZipInflaterInputStream.class
                ├── [1.5K]  JarLauncher.class
                ├── [1.5K]  LaunchedURLClassLoader$UseFastConnectionExceptionsEnumeration.class
                ├── [5.6K]  LaunchedURLClassLoader.class
                ├── [4.6K]  Launcher.class
                ├── [1.5K]  MainMethodRunner.class
                ├── [ 266]  PropertiesLauncher$1.class
                ├── [1.4K]  PropertiesLauncher$ArchiveEntryFilter.class
                ├── [1.9K]  PropertiesLauncher$PrefixMatchingArchiveFilter.class
                ├── [ 19K]  PropertiesLauncher.class
                ├── [4.0K]  util
                │   └── [5.1K]  SystemPropertyUtils.class
                └── [1.7K]  WarLauncher.class

20 directories, 92 files

```
传统 JAR 解压 ：
```$xslt
root@kali:/tmp/jar01# tree . -h 
.
├── [2.7K]  chapter2-1.0-SNAPSHOT.jar
├── [4.0K]  META-INF
│   ├── [ 150]  MANIFEST.MF
│   └── [4.0K]  maven
│       └── [4.0K]  xmg.spring.boot.samples
│           └── [4.0K]  chapter2
│               ├── [  73]  pom.properties
│               └── [ 971]  pom.xml
└── [4.0K]  xmg
    └── [4.0K]  spring
        └── [4.0K]  boot
            └── [4.0K]  samples
                └── [4.0K]  chapter2
                    └── [ 817]  FirstAppByGuiApplication.class

9 directories, 5 files

```
#### 2.2.3 FAT JAR 和 WAR 执行模块 -- spring-boot-loader
传统 JAR 文件的 MANIFEST.MF 
```$xslt
root@kali:/tmp/jar01/META-INF# cat MANIFEST.MF 
Manifest-Version: 1.0
Implementation-Title: chapter2
Implementation-Version: 1.0-SNAPSHOT
Build-Jdk-Spec: 1.8
Created-By: Maven Archiver 3.4.0

```

插件编译的 JAR 文件的 MANIFEST.MF 
```$xslt
root@kali:/tmp/jar01/META-INF# cat MANIFEST.MF 
Manifest-Version: 1.0
Implementation-Title: chapter2
Implementation-Version: 1.0-SNAPSHOT
Start-Class: xmg.spring.boot.samples.chapter2.FirstAppByGuiApplication
Spring-Boot-Classes: BOOT-INF/classes/
Spring-Boot-Lib: BOOT-INF/lib/
Build-Jdk-Spec: 1.8
Spring-Boot-Version: 2.1.5.RELEASE
Created-By: Maven Archiver 3.4.0
Main-Class: org.springframework.boot.loader.JarLauncher

```

命令```java -jar``` 启动程序必须要在 ```MANIFEST.MF``` 中指定 ```Main-Class```

JarLauncher：
> 用于启动 jar

WarLauncher：
> 用于启动 war

直接运行 JarLauncher 
```$xslt
root@kali:/tmp/jar02# ls
BOOT-INF  chapter2-1.0-SNAPSHOT.jar  META-INF  org
root@kali:/tmp/jar02# java org.springframework.boot.loader.JarLauncher

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.5.RELEASE)

2019-07-13 10:19:24.676  INFO 11198 --- [           main] x.s.b.s.c.FirstAppByGuiApplication       : Starting FirstAppByGuiApplication on kali with PID 11198 (/tmp/jar02/BOOT-INF/classes started by root in /tmp/jar02)
2019-07-13 10:19:24.679  INFO 11198 --- [           main] x.s.b.s.c.FirstAppByGuiApplication       : No active profile set, falling back to default profiles: default
2019-07-13 10:19:25.790  INFO 11198 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2019-07-13 10:19:25.817  INFO 11198 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2019-07-13 10:19:25.818  INFO 11198 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.19]
2019-07-13 10:19:25.912  INFO 11198 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2019-07-13 10:19:25.912  INFO 11198 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1194 ms
2019-07-13 10:19:26.128  INFO 11198 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2019-07-13 10:19:26.359  INFO 11198 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2019-07-13 10:19:26.364  INFO 11198 --- [           main] x.s.b.s.c.FirstAppByGuiApplication       : Started FirstAppByGuiApplication in 2.07 seconds (JVM running for 2.444)


```

#### 2.2.4 JarLauncher 的实现原理

## 第三章 理解固话的 Maven 依赖

### 3.2 spring-boot-starter-parent 与 spring-boot-dependencies
> 为了统一管理 spring-boot 组件的版本，可以继承 spring-boot-starter-parent 也可以依赖 spring-boot-dependencies  
其实 spring-boot-starter-parent 继承自 spring-boot-dependencies 所以我们也可以继承 spring-boot-dependencies  
spring-boot-dependencies 中对以来的jar做了版本控制  


## 第四章 理解嵌入式 Web 容器

### 4.1 嵌入式 Servlet Web 容器 

* Tomcat
默认的 spring-boot-starter-web 包含 Tomcat 
```text
Tomcat started on port(s): 8080 (http) with context path ''

```


* Jetty
```xml
        <dependency>
            <!--Tomcat-->
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>

            <!--排除 Tomcat-->
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <!--使用 Jetty-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jetty</artifactId>
        </dependency>

```
输出：
```text
Connected to the target VM, address: '127.0.0.1:33651', transport: 'socket'

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.5.RELEASE)

2019-07-13 22:50:56.647  INFO 7221 --- [           main] x.s.b.s.c.FirstAppByGuiApplication       : Starting FirstAppByGuiApplication on kali with PID 7221 (/opt/Codes/xmg-spring-boot-samples/chapter4/target/classes started by root in /opt/Codes/xmg-spring-boot-samples)
2019-07-13 22:50:56.649  INFO 7221 --- [           main] x.s.b.s.c.FirstAppByGuiApplication       : No active profile set, falling back to default profiles: default
2019-07-13 22:50:57.680  INFO 7221 --- [           main] org.eclipse.jetty.util.log               : Logging initialized @2065ms to org.eclipse.jetty.util.log.Slf4jLog
2019-07-13 22:50:57.732  INFO 7221 --- [           main] o.s.b.w.e.j.JettyServletWebServerFactory : Server initialized with port: 8080
2019-07-13 22:50:57.735  INFO 7221 --- [           main] org.eclipse.jetty.server.Server          : jetty-9.4.18.v20190429; built: 2019-04-29T20:42:08.989Z; git: e1bc35120a6617ee3df052294e433f3a25ce7097; jvm 1.8.0_211-b12
2019-07-13 22:50:57.763  INFO 7221 --- [           main] o.e.j.s.h.ContextHandler.application     : Initializing Spring embedded WebApplicationContext
2019-07-13 22:50:57.763  INFO 7221 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 999 ms
2019-07-13 22:50:57.840  INFO 7221 --- [           main] org.eclipse.jetty.server.session         : DefaultSessionIdManager workerName=node0
2019-07-13 22:50:57.840  INFO 7221 --- [           main] org.eclipse.jetty.server.session         : No SessionScavenger set, using defaults
2019-07-13 22:50:57.841  INFO 7221 --- [           main] org.eclipse.jetty.server.session         : node0 Scavenging every 600000ms
2019-07-13 22:50:57.848  INFO 7221 --- [           main] o.e.jetty.server.handler.ContextHandler  : Started o.s.b.w.e.j.JettyEmbeddedWebAppContext@2e3f79a2{application,/,[file:///tmp/jetty-docbase.768196404040356109.8080/],AVAILABLE}
2019-07-13 22:50:57.848  INFO 7221 --- [           main] org.eclipse.jetty.server.Server          : Started @2234ms
2019-07-13 22:50:57.986  INFO 7221 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2019-07-13 22:50:58.124  INFO 7221 --- [           main] o.e.j.s.h.ContextHandler.application     : Initializing Spring DispatcherServlet 'dispatcherServlet'
2019-07-13 22:50:58.125  INFO 7221 --- [           main] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2019-07-13 22:50:58.130  INFO 7221 --- [           main] o.s.web.servlet.DispatcherServlet        : Completed initialization in 5 ms
2019-07-13 22:50:58.145  INFO 7221 --- [           main] o.e.jetty.server.AbstractConnector       : Started ServerConnector@7fc645e4{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
2019-07-13 22:50:58.148  INFO 7221 --- [           main] o.s.b.web.embedded.jetty.JettyWebServer  : Jetty started on port(s) 8080 (http/1.1) with context path '/'
2019-07-13 22:50:58.150  INFO 7221 --- [           main] x.s.b.s.c.FirstAppByGuiApplication       : Started FirstAppByGuiApplication in 1.893 seconds (JVM running for 2.535)

```
* Undertow

```xml
        <!--使用 undertow-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-undertow</artifactId>
        </dependency>
```
```text
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.5.RELEASE)

2019-07-13 23:02:18.997  INFO 7839 --- [           main] x.s.b.s.c.FirstAppByGuiApplication       : Starting FirstAppByGuiApplication on kali with PID 7839 (/opt/Codes/xmg-spring-boot-samples/chapter4/target/classes started by root in /opt/Codes/xmg-spring-boot-samples)
2019-07-13 23:02:18.999  INFO 7839 --- [           main] x.s.b.s.c.FirstAppByGuiApplication       : No active profile set, falling back to default profiles: default
2019-07-13 23:02:19.906  WARN 7839 --- [           main] io.undertow.websockets.jsr               : UT026010: Buffer pool was not set on WebSocketDeploymentInfo, the default pool will be used
2019-07-13 23:02:19.924  INFO 7839 --- [           main] io.undertow.servlet                      : Initializing Spring embedded WebApplicationContext
2019-07-13 23:02:19.924  INFO 7839 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 895 ms
2019-07-13 23:02:20.085  INFO 7839 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2019-07-13 23:02:20.214  INFO 7839 --- [           main] org.xnio                                 : XNIO version 3.3.8.Final
2019-07-13 23:02:20.220  INFO 7839 --- [           main] org.xnio.nio                             : XNIO NIO Implementation Version 3.3.8.Final
2019-07-13 23:02:20.263  INFO 7839 --- [           main] o.s.b.w.e.u.UndertowServletWebServer     : Undertow started on port(s) 8080 (http) with context path ''
2019-07-13 23:02:20.265  INFO 7839 --- [           main] x.s.b.s.c.FirstAppByGuiApplication       : Started FirstAppByGuiApplication in 1.527 seconds (JVM running for 2.073)

```

### 4.2 嵌入式 Reactive Web 容器 
同时存在 ```spring-boot-starter-web``` 和 ```spring-boot-starter-webflux```  
自动忽略后者  

* undertow 
```xml

 <!--       <dependency>
            &lt;!&ndash;Tomcat&ndash;&gt;
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>

            &lt;!&ndash;排除 Tomcat&ndash;&gt;
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
            </exclusions>
        </dependency>-->

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
        </dependency>

        <!--使用 undertow-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-undertow</artifactId>
        </dependency>


```

```text
Connected to the target VM, address: '127.0.0.1:39157', transport: 'socket'

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.5.RELEASE)

2019-07-13 23:08:55.733  INFO 8412 --- [           main] x.s.b.s.c.FirstAppByGuiApplication       : Starting FirstAppByGuiApplication on kali with PID 8412 (/opt/Codes/xmg-spring-boot-samples/chapter4/target/classes started by root in /opt/Codes/xmg-spring-boot-samples)
2019-07-13 23:08:55.756  INFO 8412 --- [           main] x.s.b.s.c.FirstAppByGuiApplication       : No active profile set, falling back to default profiles: default
2019-07-13 23:08:56.931  INFO 8412 --- [           main] org.xnio                                 : XNIO version 3.3.8.Final
2019-07-13 23:08:56.939  INFO 8412 --- [           main] org.xnio.nio                             : XNIO NIO Implementation Version 3.3.8.Final
2019-07-13 23:08:56.991  INFO 8412 --- [           main] o.s.b.w.e.undertow.UndertowWebServer     : Undertow started on port(s) 8080 (http)
2019-07-13 23:08:56.994  INFO 8412 --- [           main] x.s.b.s.c.FirstAppByGuiApplication       : Started FirstAppByGuiApplication in 1.719 seconds (JVM running for 2.566)

```

```java
    /**
     * webflux
     */
    @Bean
    public RouterFunction<ServerResponse> helloWorld() {
        return route(GET("/hello"), request -> ok().body(Mono.just("Hello World"), String.class));
    }
    
```

Spring Boot 应用启动后获取 WebServer  
执行 ApplicationRunner##run

```java
@SpringBootApplication
public class FirstAppByGuiApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstAppByGuiApplication.class);
    }

    /**
     * 输出 WebServer 实现类
     */
    @Bean
    public ApplicationRunner applicationRunner(WebServerApplicationContext context) {
        return args -> {
            System.out.println("当前 WebServer 实现类：" +
                    context.getWebServer().getClass().getName());
        };
    }
}

```

#### 4.2.3 WebServerInitializedEvent  
获取服务的端口  
修改上面的例子  
```java
    /**
     * 输出 WebServer 实现类
     */
    @Bean
    public ApplicationRunner applicationRunner(WebServerApplicationContext context) {
        return args -> {
            System.out.println("当前 WebServer 实现类：" +
                    context.getWebServer().getClass().getName() +
                    " ,port:" + context.getWebServer().getPort());
        };
    }
```
WebServerInitializedEvent 获取 当前 WebServer 实现类 
```java
    /**
     * EventListener 获取 当前 WebServer 实现类
     */
    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerRready(WebServerInitializedEvent event) {
        System.out.println("EventListener 获取 当前 WebServer 实现类：" +
                event.getWebServer().getClass().getName() +
                " ,port:" + event.getWebServer().getPort());
    }
```
结果：
```text
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.5.RELEASE)

2019-07-14 05:21:02.222  INFO 14323 --- [           main] x.s.b.s.c.FirstAppByGuiApplication       : Starting FirstAppByGuiApplication on kali with PID 14323 (/opt/Codes/xmg-spring-boot-samples/chapter4/target/classes started by root in /opt/Codes/xmg-spring-boot-samples)
2019-07-14 05:21:02.224  INFO 14323 --- [           main] x.s.b.s.c.FirstAppByGuiApplication       : No active profile set, falling back to default profiles: default
2019-07-14 05:21:03.440  INFO 14323 --- [           main] org.xnio                                 : XNIO version 3.3.8.Final
2019-07-14 05:21:03.446  INFO 14323 --- [           main] org.xnio.nio                             : XNIO NIO Implementation Version 3.3.8.Final
2019-07-14 05:21:03.492  INFO 14323 --- [           main] o.s.b.w.e.undertow.UndertowWebServer     : Undertow started on port(s) 8080 (http)
EventListener 获取 当前 WebServer 实现类：org.springframework.boot.web.embedded.undertow.UndertowWebServer ,port:8080
2019-07-14 05:21:03.495  INFO 14323 --- [           main] x.s.b.s.c.FirstAppByGuiApplication       : Started FirstAppByGuiApplication in 1.598 seconds (JVM running for 2.022)
当前 WebServer 实现类：org.springframework.boot.web.embedded.undertow.UndertowWebServer ,port:8080

```

WebServerInitializedEvent 事件比 ApplicationRunner 更早触发  

* Jetty
替换为Jetty  
```xml
        <!--使用 Jetty-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jetty</artifactId>
        </dependency>
```

* Tomcat
替换为Tomcat  
```xml
        <!--使用 tomcat-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </dependency>
```

* Netty
啥都不依赖，默认是 Netty
```text
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.5.RELEASE)

2019-07-14 05:32:57.356  INFO 16841 --- [           main] x.s.b.s.c.FirstAppByGuiApplication       : Starting FirstAppByGuiApplication on kali with PID 16841 (/opt/Codes/xmg-spring-boot-samples/chapter4/target/classes started by root in /opt/Codes/xmg-spring-boot-samples)
2019-07-14 05:32:57.360  INFO 16841 --- [           main] x.s.b.s.c.FirstAppByGuiApplication       : No active profile set, falling back to default profiles: default
2019-07-14 05:32:58.681  INFO 16841 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port(s): 8080
EventListener 获取 当前 WebServer 实现类：org.springframework.boot.web.embedded.netty.NettyWebServer ,port:8080
2019-07-14 05:32:58.685  INFO 16841 --- [           main] x.s.b.s.c.FirstAppByGuiApplication       : Started FirstAppByGuiApplication in 1.774 seconds (JVM running for 2.349)
当前 WebServer 实现类：org.springframework.boot.web.embedded.netty.NettyWebServer ,port:8080

```

## 第五章　理解自动装配

## 第六章　理解 Production Ready 特性

## 第七章 走向注解驱动编程

## 第八章 Spring 注解驱动设计模式

## 第九章 Spring Boot 自动装配

## 第十章 SpringApplication 初始化阶段

## 第十一章 SpringApplication 运行阶段

## 第十二章 SpringApplication 结束阶段

## 值得注意

### maven 编译指定 java 版本
```xml
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
    </properties>
    
```
```xml
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compier-plugin</artifactId>
                <version>3.7.0</version>
                <configuration>
                    <souce>${java.version}</souce>
                    <target>${java.version}</target>
                </configuration>
            </plugin>
```


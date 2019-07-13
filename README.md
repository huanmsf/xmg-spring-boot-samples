# 《Spring Boot 编程思想 》学习笔记
> [小马哥《Spring Boot 编程思想 》](https://github.com/mercyblitz/thinking-in-spring-boot-samples)

## 第一章 初览 Spring Boot

## 第二章 理解独立的 Spring 应用

### 2.2 运行 Spring Boot 应用
* > idea 启动
* > mvn spring-boot:run 

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

## 第四章 理解嵌入式 Web 容器

## 第五章　理解自动装配

## 第六章　理解 Production Ready 特性

## 第七章 走向注解驱动编程

## 第八章 Spring 注解驱动设计模式

## 第九章 Spring Boot 自动装配

## 第十章 SpringApplication 初始化阶段

## 第十一章 SpringApplication 运行阶段

## 第十二章 SpringApplication 结束阶段


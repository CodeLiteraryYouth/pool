项目简介
jdbc-pool 是一款简化版的 jdbc-pool 实现。

Maven Central Build Status  Open Source Love

创作目的
学习 jdbc-pool 的原理

便于拓展自己的数据库工具

特性
基本的数据库连接池实现

自动适配 jdbc 驱动类

支持各种场景对于连接的校验

快速开始
需要
jdk 1.7+

maven 3.x+

maven 引入
<dependency>
    <groupId>com.github.houbb</groupId>
    <artifactId>jdbc-pool</artifactId>
    <version>1.5.0</version>
</dependency>
测试代码
UnPooledDataSource source = new UnPooledDataSource();
source.setDriverClass("com.mysql.jdbc.Driver");
source.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8");
source.setUser("root");
source.setPassword("123456");

Connection connection = source.getConnection();
池化的实现
PooledDataSource source = new PooledDataSource();
source.setDriverClass("com.mysql.jdbc.Driver");
source.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8");
source.setUser("root");
source.setPassword("123456");
source.setMinSize(1);

// 初始化
source.init();

Connection connection = source.getConnection();
System.out.println(connection.getCatalog());

Connection connection2 = source.getConnection();
System.out.println(connection2.getCatalog());
输出日志
[DEBUG] [2020-07-18 10:50:54.536] [main] [c.g.h.t.p.d.PooledDataSource.getFreeConnection] - 从连接池中获取连接
test
[DEBUG] [2020-07-18 10:50:54.537] [main] [c.g.h.t.p.d.PooledDataSource.getConnection] - 开始扩容连接池大小，step: 1
[DEBUG] [2020-07-18 10:50:54.548] [main] [c.g.h.t.p.d.PooledDataSource.getConnection] - 从扩容后的连接池中获取连接
test
第一次默认直接从线程池中获取，第二次为重新创建的信息。

后期 road-map
根据 url 自动识别 driverClass

添加获取的等待

添加设置为繁忙的状态 check

添加日志替代 sout

添加 validQuery, testOnBorrow, testOnReturn, testWhileIdle

添加 filter-chain

添加监控页面实现

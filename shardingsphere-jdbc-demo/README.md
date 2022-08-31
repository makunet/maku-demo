## 项目介绍
本案例，主要提供shardingsphere-jdbc的集成方案，实现读写分离，分库分表功能的DEMO。

## 准备工作
1. 创建数据库maku_demo_write，用于写数据
2. 创建数据库maku_demo_read，用于读数据
3. 在这2个数据库里面，分别执行下面的MySQL语句，用于测试读写分离
```sql
CREATE TABLE tb_user
(
    id bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    username varchar(50) NOT NULL COMMENT '用户名',
    mobile varchar(50) COMMENT '手机号',
    create_time datetime COMMENT '创建时间',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='用户';
```
4. 修改application.properties里面的数据源，修改数据库的地址，账号和密码。

## 测试读写分离
我们提供了`ReadWriteTest.java`类，实现读写分离的测试代码，可分别执行readTest()、writeTest()方法，测试读、写对应的数据库。


## 测试分库分表
1. 在maku_demo_write数据库里，执行如下MySQL语句，用于测试分表（分库原理也是一样的）
```sql
CREATE TABLE tb_user_log_0
(
    id bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    name varchar(50) NOT NULL COMMENT '名称',
    content varchar(100) COMMENT '内容',
    create_time datetime COMMENT '创建时间',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='用户日志';

CREATE TABLE tb_user_log_1
(
    id bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    name varchar(50) NOT NULL COMMENT '名称',
    content varchar(100) COMMENT '内容',
    create_time datetime COMMENT '创建时间',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='用户日志';
```
2. 我们提供了`ShardingTableTest.java`类，实现分表的测试代码，执行shardingTest()方法，测试分表操作，其中我们是采用[id % 2]分表算法，也就是根据id值不同，数据会自动分布到不同的表里。

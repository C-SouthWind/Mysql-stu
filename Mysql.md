# Mysql

JavaEE：企业级Java开发 Web

前端（页面：展示，数据！）

后台（连接点：连接数据库JDBC，链接前端（控制，控制视图跳转，和给前端传递数据））

数据库（存数据，Txt，Excel，word）

>只会写代码，学好数据库，基本混饭吃！
>
>操作系统，数据结构与算法！ 当一个不错的程序员！
>
>离散数学，数字电路，体系结构，编译原理。+实战经验，高级程序员~优秀的程序员

2022-01-05  21：17

## 1.1、为什么学习数据库

1、岗位需求

2、现在的世界，大数据时代~ 得数据者得天下

3、被迫需求：存数据

4、数据库是所有软件体系中最核心的存在



## 1.2、什么是数据库

数据库（DB，DataBase）

概念：数据仓库，软件，安装在操作系统（window，linux，mac，....）之上！可以存储大量的数据

作用：存储数据，管理数据



## 1.3、数据库分类

**关系型数据库**（SQL）

- Mysql、Oracle、Sql Server、DB2、SQL Lite
- 通过表和表之间，行和列之间的关系进行数据的存储

**非关系型数据库**（NoSQL） Not Only

- Redis、MongDB
- 非关系型数据库，对象存储，通过对象的自身的属性来决定



**DBMS（数据库管理系统）**

- 数据库的管理软件，科学有效的管理我们的数据。维护和获取数据
- MySQL，数据库管理系统！



## 1.4、MySQL简介

MySQL是一个**关系型数据库管理系统**

前世：瑞典MySQL AB

今生：属于 Oracle 旗下产品

MySQL是最好的 [RDBMS](https://baike.baidu.com/item/RDBMS/1048260) (Relational Database Management System，关系数据库管理系统) 应用软件之一。

开源的数据库软件

体积小、速度快、总体拥有成本低，招人成本比较低

中小型网站、或者大型网站、集群！



安装建议：

1. 尽量不要使用exe安装，会有注册表信息 卸载麻烦
2. 尽可能使用压缩包安装



## 1.5、安装Mysql

安装MySQL
**这里建议大家使用压缩版,安装快,方便.不复杂.**
**软件下载**
mysql5.7 64位下载地址:
https://dev.mysql.com/get/Downloads/MySQL-5.7/mysql-5.7.19-winx64.zip
电脑是64位的就下载使用64位版本的！



1、下载后得到zip压缩包.

2、解压到自己想要安装到的目录，本人解压到的是D:\Environment\mysql-5.7.19

3、添加环境变量：我的电脑->属性->高级->环境变量

```php
选择PATH,在其后面添加: 你的mysql 安装文件下面的bin文件夹
```

4、编辑 my.ini 文件 ,注意替换路径位置

```php
[mysqld]
#根目录
basedir=D:\Program Files\mysql-5.7\
#根目录 不要自己创建data文件
datadir=D:\Program Files\mysql-5.7\data\
#端口号
port=3306
#跳过密码验证
skip-grant-tables
```

5、启动管理员模式下的CMD，并将路径切换至mysql下的bin目录，然后输入mysqld –install (安装mysql)

```php
Service successfully installed
```



6、再输入  mysqld --initialize-insecure --user=mysql 初始化数据文件

```php
会自动现data文件
```

7、然后再次启动mysql 然后用命令 mysql –u root –p 进入mysql管理界面（密码可为空）

```php
#启动mysql
net start mysql
```



8、进入界面后更改root密码

```php
update mysql.user set authentication_string=password('123456') where user='root' and Host = 'localhost';
```

9、刷新权限

```php
flush privileges;
```

10、修改 my.ini文件删除最后一句skip-grant-tables或者注释#skip-grant-tables

11、重启mysql即可正常使用

```php
net stop mysql
net start mysql
```

12、连接上测试出现以下结果就安装好了

```php
mysql –u root –p
	密码 123456
或者
mysql –u root –p+密码
    mysql –u root –p123456
```



![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy91SkRBVUtyR0M3SkRBbGdFaGljUWZ5VWVrbGVmclVoWWliNWpuMGdnV0x0SXJWaWF2QWNCcE9YVzJpY2syaWJJMnVuNjNnTHJGTWR0dmlhbVl4dHRYMmtub1BpYlEvNjQw?x-oss-process=image/format,png)

一步步去做 , 理论上是没有任何问题的 .

如果您以前装过,现在需要重装,一定要将环境清理干净 .



# 2、操作数据库

## 2.1、数据库列类型

> 数值

- tinyint   	             十分小的数据           1字节
- smallint                 较小的数据               2字节
- mediumint            中等大小的数据       3字节
- **int                           标准的整数              4字节（常用）**
- bigint                      较大的数据               8字节
- float                         浮点数                      4字节
- double                    浮点数                       8字节
- decimal                  字符串形式的浮点数  金融计算的时候，一般是使用decimal

> 字符串

- char						字符串固定大小的          0~255
- **varchar                  可变字符串                      0~65535（常用）**
- tinytext                  微型文本                          2^8  -1
- text                         文本穿                             2^16 -1

> 时间日期

- data                        YYYY-MM-DD                           日期格式
- time                        HH:mm:ss                                时间格式
- **datetime                YYYY-MM-DD HH:mm:ss       最常用的时间格式**
- timestamp              时间戳 ，1970.1.1 到现在的毫秒数！
- year                          年份

> null

- 没有值，未知
- 注意，不要使用NULL进行运算，结果为NULL

## 2.2、数据库的字段属性

Unsigned：

- 无符号的整数
- 声明了该列不能声明为负数

zerofill：

- 0填充的
- 不足的位数，使用0来填充，int（3）  5 ----- 005

自增：

- 通常理解为自增，自动在上一条记录的基础上+1（默认）
- 通常用来设计唯一的主键~ index，必须是整数类型
- 可以自定义设计主键的起始值和步长

非空 NULL  not null

- 假设设置为not  null，如果不给它赋值，就会报错！
- NULL，如果不填写值，默认就是null！

默认：

- 设置默认的值！
- sex，默认值为男，如果不指定该列的值，则会有默认的值！

```sql
/*每一个表，都必须存在以下五个字段！表示一个记录存在意义*/

id  		主键
version 	乐观锁
is_delete   伪删除
gmt_create	创建时间
gmt_update  修改时间
```

## 2.3、创建数据库表

格式

```sql
CREATE TABLE [IF NOT EXISTS] `表名`(
	`字段名` 列类型 [属性] [索引] [注释]，
    `字段名` 列类型 [属性] [索引] [注释]，
    ......
    `字段名` 列类型 [属性] [索引] [注释]
)[表类型][字符集设置][注释]
```

常用命令

```sql
SHOW CREATE DATABASE user -- 查看创建数据库的语句
SHOW CREATE TABLE user -- 查看user数据表的定义语句
DESC user -- 显示表的结构
```

## 2.4、数据库的类型

```sql
-- 数据的引擎
/*
	INNODB  默认使用
	MYISAM  早些年使用
*/
```

|            | MYISAM | INNODB        |
| ---------- | ------ | ------------- |
| 事务锁定   | 不支持 | 支持          |
| 数据行锁定 | 不支持 | 支持          |
| 外键约束   | 不支持 | 支持          |
| 全文索引   | 支持   | 不支持        |
| 表空间大小 | 较小   | 较大，约为2倍 |

常规使用操作：

- MYISAM	：节约空间，速度较快
- INNODB    ：安全性高，事务的处理，夺表多用户操作

> 在物理空间存在的位置

所有的数据库文件都存在data目录下

本质还是文件的存储

MySQL引擎在物理文件上的区别

- InnoDB在数据库表中只有一个 *.frm文件，以及上级目录下的ibdata1文件
- MYISAM对应文件
  - *.frm      表结构的定义文件
  - *.MYD    数据文件（data）
  - *.MYI      索引文件（index）

> 设置数据库表的字符集编码
>
> CHARSET=utf8

不设置的话，会是mysql默认的字符集编码~（不支持中文！）

MySQL的默认编码是Latin1 不支持中文

在my.ini中配置默认的编码

```sql
character-set-server=utf8
```

## 2.5、修改删除表

> 修改

```sql
-- 修改表名
	ALTER TABLE 旧表名 RENAME AS 新表名
-- 新增表的字段
	ALTER TABLE 表名 ADD 字段名 列属性
-- 修改表的字段（重命名，修改约束！）
	ALTER TABLE 表名 MODIFY 字段名 列属性[] -- 修改约束
	ALTER TABLE 表名 CHANGE 旧名字 新名字 列属性[]
-- 删除表的字段
	ALTER TABLE 表名 DROP 字段名
```

> 删除

```sql
-- 删除表（如果表存在再删除）
DROP TABLE IF EXISTS 表名
```

所有的创建和删除操作尽量加上判断，以免报错~

注意：

- ``字段名，使用这个包裹！
- 注释 --   /**/
- sql关键字大小写不敏感，建议小写

# 3、MySQL数据管理

## 3.1、外键

> 方式一：在创建表的时候，增加约束

> 方式二：创建表成功后，添加外键约束

```sql
ALTER TABLE 表 ADD CONSTRAINT 约束名 FOREIGN KEY(作为外键的列) REFERENCES 那个表（哪个字段）
```

以上的操作都是物理外键，数据库级别的外键，我们不建议使用！（避免数据库过多造成困扰，了解即可）

最佳实践

- 数据库就是单纯的表，只用来存数据，只有行（数据）和列（字段）
- 我们想使用多张表，想使用外键（程序去实现）



## 3.2、DML语言

**数据库意义**： 数据存储，数据管理

DML语言：数据操作语言

- Insert
- Update
- Delete

## 3.3、添加

> Insert

```sql
insert into 表名 ([字段1],[字段2],[字段3]) values([值1],[值2],[值3])
```

注意：

1. 字段和字段之间使用逗号，隔开
2. 字段是可以省略的，但是后面的值必须要一一对应
3. 可以同时插入多条数据，values后面的值，需要使用，隔开即可 values（）,（）....

## 3.4、修改

> update

```sql
update 表名 set 字段名 = 值,[字段名 = 值] where [条件] 
```

条件  操作符会返回布尔值

| 操作符           | 含义         | 范围        | 结果  |
| ---------------- | ------------ | ----------- | ----- |
| =                | 等于         | 5=6         | false |
| <>或！=          | 不等于       | 5<>6        | true  |
| >                |              |             |       |
| <                |              |             |       |
| <=               |              |             |       |
| BETWEEN...AND... | 在某个范围内 | [2,5]       |       |
| AND              | 我和你 &&    | 5>1 and 1>2 | false |
| OR               | 我或你 \|\|  | 5>1 or 1>2  | true  |
|                  |              |             |       |

注意：

- 字段名尽量带上``
- 条件，筛选的条件，如果没有指定，则会修改所有的列



## 3.5、删除

> delete

```sql
delete from 表名 [where 条件]
```



> TRUNCATE命令

```sql
truncate 表名
```

作用：完全情况一个数据库表，表的结构和索引约束不会变！



区别：

- 相同点：都能删除数据，都不会删除表结构
- 不同：
  - truncate 重新设置自增列 计数器会归零
  - truncate 不会影响事务

delete删除的问题

- InnoDB   自增列会从1开始（存在内存当中，断电即失）
- MyISAM  继续从上一个自增量开始（存在文件中，不会丢失）



# 4、DQL查询数据

## 4.1、DQL

（Data Query LANGUAGE：数据查询语言）

- 所有的查询操作都用它 select
- 简单的查询，复杂的查询它都能做
- 数据库中最核心的语言，最重要的语句
- 使用频率最高的语句

> select完整语法

```sql
SELECT [ALL | DISTINCT]
{* | tbale.* | [table.field1[as alias1][,table.field2[as alias2]][,.....]]}
FROM table_name [as table_alias]
	[left | right | inner jin table_name2] -- 联合查询
	[where ...] -- 指定结果需要满足的条件
	[GROUP BY ...] -- 指定结果安装哪几个字段来分组
	[HAVING ...] -- 过滤分组的记录必须满足的次要条件
	[ORDER BY ...] -- 指定查询记录按一个或多个条件排序
	[LIMIT {[offset,] row_count | row_countOFFSET offset}]; -- 指定查询的记录从哪条至哪条
注意：[]括号代表可选，{}括号代表必须选
```





## 4.2、指定查询字段

> select

```sql
-- 查询全部数据
SELECT * FROM 表名

-- 查询指定字段
SELECT 字段1,字段2 FROM 表名

-- 查询起别名
SELECT 字段1 AS 字段1别名 FROM 表名

-- 函数 Concat(a,b)
SELECT CONCAT(字段/值 , 字段1) AS 字段1别名 FROM 表名
```



> 去重  distinct

```sql
SELECT DISTINCT 字段1 FROM 表名
```

作用：去除select查询出来的结果中重复的数据，重复的数据只显示一条



> 数据库的列（表达式）

```sql
SELECT VERSION() -- 查询系统版本号（函数）
SELECT 100*3-1 AS 计算结果  -- 用来计算（表达式）
SELECT @@auto_increment_increment -- 查询自增的步长（变量）
SELECT 字段1+1 AS 字段别名 FROM 表名 -- 字段1 加1查看
```

数据库中表达式：文本值，列，NULL，函数，计算表达式，系统变量....

## 4.3、where条件字句

作用：检索数据中符合条件的值

搜索的条件由一个或者多个表达式组成！结果布尔值

> 逻辑运算符

| 运算符    | 语法               | 描述                             |
| --------- | ------------------ | -------------------------------- |
| and   &&  | a and b     a&&b   | 逻辑与，两个都为真，结果为真     |
| or   \|\| | a or b    a \|\| b | 逻辑或，其中一个为真，则结果为真 |
| not   !   | not a     ！a      | 逻辑非，真为假，假为真！         |

尽量使用英文字母

```sql
select * from 表名  where  条件
						 	a > 90 and a < 100
						 	a > 90 &&  a < 100
						 	a between 90 and 100
						 	a != 100
						 	not a = 100
```



> 模糊查询：比较运算符

| 运算符      | 语法                 | 描述                                              |
| ----------- | -------------------- | ------------------------------------------------- |
| IS  NULL    | a is null            | 如果操作符为NULL,结果为真                         |
| IS NOT NULL | a is not null        | 如果操作符不为null，结果为真                      |
| BETWEEN     | a between b and c    | 若a 在 b 和 c 之间，则结果为真                    |
| LIKE        | a  like b            | SQL匹配，如果a匹配b，则结果为真                   |
| IN          | a in (a1,a2,a3.....) | 假如a在a1，或者a2..... 其中的某一个值中，结果为真 |

```sql
-- 模糊查询
-- like 结合 %(代表0到任意个字符)  _(一个字符)
select * from 表名 where  条件
						  a like '陈%'
						  a like '陈_'
						  a like '陈__'
						  a like '%陈%'
						  a in ('100','101','102')
						  a = '' and a is null
						  a is not null
						  a is null
```

## 4.4、联表查询

> join对比

![image-20211227194209580](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20211227194209580.png)

![See the source image](https://www.freesion.com/images/547/a2335aa71a14b277f2969b6117f5bd2b.png)

```sql
-- left join
select * from 表名a 
left join 表名b 
on 表名a.id = 表名b.id

-- right join
select * from 表名a 
right join 表名b 
on 表名a.id = 表名b.id

-- inner join
select * from 表名a 
inner join 表名b 
on 表名a.id = 表名b.id
```

| 操作           | 描述                                       |
| -------------- | ------------------------------------------ |
| inner  join    | 如果表中至少有一个匹配，就返回行           |
| left      join | 会从左表中返回所有的值，即使右表中没有匹配 |
| right   join   | 会从右表中返回所有的值，即使左表中没有匹配 |



> 自连接

自己的表和自己的表连接，核心：一张表拆为两张一样的表即可

```sql
select a.CORP_NAME as 'fu',b.CORP_NAME as 'zi' from 
sys_corp a ,sys_corp b
where a.EXTN_CORP_NO = b.SUPERIOR
```

## 4.5、分页和排序

> 分页

```sql
-- 第一页   limit 0,5		(1-1)*5
-- 第二页   limit 5,5		(2-1)*5
-- 第三页   limit 10,5		(3-1)*5
-- 第N页    limit 0,5		(N-1)* pageSize
-- [pageSize：页面大小]
-- [(n-1) * pageSize：起始值]
-- [n ：当前页]
-- [数据总数/页面大小 = 总页数]
```

语法 limit（查询起使下标，pageSize）

## 4.6、子查询

where （这个值是计算出来的）

本质：在where语句中嵌套一个子查询语句

```sql
select * from 表名a
where  表名a.id in (select id from 表名b)
```



# 5、MySQL函数

官网：https://dev.mysql.com/doc/refman/5.7/en/built-in-function-reference.html

## 5.1、常用函数

```sql
-- 数学运算
select abs(-8)		-- 绝对值
select ceiling(9.4)	-- 向上取整
select floor(9.4)	-- 向下取整
select rand()		-- 返回一个0~1之间的随机数
select sing(10)		-- 判断一个数的符号 0-0  负数返回-1 正数返回 1


-- 字符串函数
select char_length('即使再小的帆也能远航') -- 字符串长度
select concat('我','爱','你们') -- 拼接字符串
select insert('我爱编程helloworld',1,2,'超级热爱') -- 查询，从某个位置开始替换某个长度
select lower('chenhaojie') -- 小写字母
select upper('chenhaojie') -- 大写字母
select insert('我说坚持就能成功','坚持'，'努力') -- 替换出现的指定字符串
select substr('我说坚持就能成功'，4，6) -- 返回指定的子字符串（源字符串，截取的位置，截取的长度）
select reverse("反转字符串") -- 反转


-- 时间和日期函数
select current_date() -- 获取当前日期
select curdate() -- 获取当前日期
select now() -- 获取当前日期
select localtime() -- 本地时间
select sysdate() -- 系统时间
select year(now()) -- 年
select month(now()) -- 月
select day(now()) -- 日
select hour(now()) -- 时
select minute(now()) -- 分
select second(now()) -- 秒

-- 系统
select system_user() -- 用户
select user() -- 用户
select version() -- 版本号
```



## 5.2、聚合函数

| 函数名称  | 描述 |
| --------- | ---- |
| count（） | 计数 |
| sum（）   | 求和 |
| avg（）   | 平均 |
| max（）   | 最大 |
| min（）   | 最小 |
| ......    |      |



## 5.3、数据库级别的MD5加密（扩展）

什么是MD5?

主要增加算法复杂度和不可逆性

MD5不可逆，具体的值的md5是一样的

MD5破解网站的原理，背后有一个字典，MD5加密后的值，加密的前值

> MD5

```sql
-- 加密全部的密码
update 表名 set pwd = MD5(pwd)
-- 新增的时候加密
insert into 表名 values(1,'zhanghu',MD5('密码'))
-- 将用户传递过来的密码，进行md5加密，然后对比加密后的值
select * from 表名 where name = 'zhangsan' and pwd = MD5(pwd)
```



# 6、事务

## 6.1、什么是事务

要么都成功，要么都失败

> 事务原则：ACID原则  原子性，一致性，隔离性，持久性（脏读，幻读.....）

### 原子性（Atomicity）：

要么都成功，要么都失败

### 一致性（Consistency）：

事务前后的数据完整性要保证一致

### 隔离性（Isolation）:

不能被其他事务的操作数据所干扰，事务之间要互相隔离

### 持久性（Durability）:

事务一旦提交则不可逆，被持久化到数据库中！



> 隔离所导致的一些问题

### 脏读：

指一个事务读取了另一个事务未提交的数据

### 不可重复度：

在一个事务内读取表中的某一行数据，多次读取结果不同

### 幻读：

一个事务读取到了别的事务插入的数据，导致前后读取不一致



> 执行事务

```sql
-- ===============事务===============

-- mysql 是默认开启事务自动提交的
set autocommit = 0/* 关闭*/
set autocommit = 1/* 开启（默认）*/

-- 手动处理事务
set autocommit = 0  -- 关闭自动提交

-- 事务开启
start transaction -- 标记一个事务的开始，从这个之后的sql都在同一事务内

insert xx
insert xx

-- 提交 ：持久化 （成功！）
commit
-- 回滚：回到原来的样子（失败！）
rollback

-- 了解

savepoint  -- 设置一个事务的保存点
rollback to savepoint -- 回滚到保存点
release savepoint -- 撤掉保存点 
```



```sql
-- 转账
CREATE DATABASE shop CHARACTER SET utf8 COLLATE utf8_general_ci
USE shop

CREATE TABLE `account`(
	`id` INT(3)  NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    `money` DECIMAL(9,2) NOT NULL,
    PRIMARY KEY('id')
)ENGING=INNODB DEFAULT CHARSET=utf8

INSERT INTO account('name','money')
VALUES ('A',2000.00),('B',10000.00)

-- 模拟转账：事务
SET autocommit = 0; -- 关闭自动提交
START TRANSACTION -- 开启一个事务（一组事务）

UPDATE account SET money=money-500 WHERE `name` = 'A' -- A减500
UPDATE account SET money=money+200 WHERE 'name' = 'B' -- B加500

COMMIT; -- 提交事务，就被持久化了！
ROLLBACK; -- 回滚

SET autocommit = 1; -- 恢复默认值
```



# 7、索引

> MySQL官方对索引的定义为：索引（Index） 是帮助MySQL高效获取数据的数据结构，
>
> 提取句子主干，就可以得到索引的本质：索引是数据结构



## 7.1、索引的分类

- 主键索引（PRIMARY KEY）
  - 唯一的标识，主键不可重复，只能由一个列作为主键
- 唯一索引（UNIQUE KEY）
  - 避免重复的列出现，唯一索引可以重复，多个列都可以标识唯一索引
- 常规索引（KEY/INDEX）
  - 默认的，index/key关键字来设置
- 全文索引（FullText）
  - 在特定的数据库引擎下才有，MyISAM
  - 快速定位数据

```sql
-- 索引的使用
-- 1.在创建表的时候给字段增加索引
-- 2.创建完毕后，增加索引

-- 显示所有的索引信息
SHOW INDEX FROM student

-- 增加一个全文索引（索引名）列名
ALTER TABLE 表名 ADD FULLEXT INDEX 列名(索引名)

-- EXPLAIN 分析sql执行的情况
```



## 7.2、测试索引

```sql
CREATE TABLE `app_user`(
	  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) DEFAULT '' COMMENT '用户昵称',
    `email` VARCHAR(50) NOT NULL COMMENT '用户邮箱',
    `phone` VARCHAR(20) DEFAULT '' COMMENT '手机号',
    `gender` TINYINT(4) UNSIGNED DEFAULT '0' COMMENT '性别（0：男；女：1）',
    `password` VARCHAR(100) NOT NULL COMMENT '密码',
    `age` TINYINT(4) DEFAULT '0' COMMENT '年龄',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY(`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='app用户表'



truncate app_user

-- 插入100万条数据
DELIMITER $$ -- 写函数之前必须写，标志
CREATE FUNCTION mock_data()
RETURNS INT
BEGIN
	DECLARE num INT DEFAULT 1000000;
	DECLARE i INT DEFAULT 0;
	WHILE i<num DO
	
		insert into app_user (name,email,phone,gender,password,age)values
				(concat('用户',i),
				'1298365022@qq.com',
				concat('18',floor(Rand()*999999999)),
				floor(Rand()*2),
				UUID(),
				floor(Rand()*100));

		SET i = i+1;
	END WHILE;
	RETURN i;
END;

select mock_data();


-- 未添加索引之前
explain  select * from app_user where name = '用户999'   -- 0.5S

-- id_表名_字段名
-- create index 索引名 on 表（字段）
create index id_app_user_name on app_user(`name`)

-- 添加索引后
explain  select * from app_user where name = '用户999'   -- 0.02S
```

**索引在小数据量的时候，用处不大，但是在大数据的时候，区别十分明显**

## 7.3、索引原则

- 索引不是越多越好
- 不要对进程变动数据加索引
- 小数据量的表不需要加索引
- 索引一般加在常用来查询的字段上



# 8、权限管理

## 8.1、用户管理

```sql
-- 创建用户 设置密码
CREATE USER chj IDENTIFIED BY '123456'

-- 修改密码（修改当前用户密码）
SET PASSWORD = PASSWORD('123456')

-- 修改密码（修改指定用户密码）
SET PASSWORD FOR chj = PASSWORD('123456')

-- 重命名 RENAME USER 原来名字 TO 新的名字
RENAME USER chj TO  chj2

-- 用户授权 ALL PRIVILEGES 全部的权限 ， 库.表
-- ALL PRIVILEGES ON *.* TO chj2
GRANT ALL PRIVILEGES ON *.* TO chj2

-- 查询权限
SHOW GRANTS FOR chj2  -- 查看指定用户的权限
SHOW GRANTS FOR root@localhost -- 查看管理员权限

-- 撤销权限 REVOKE 哪些权限，在哪个库撤销，给谁撤销
REVOKE ALL PRIVILEGES ON *.* FROM chj2

-- 删除用户
DROP USER chj2
```

## 8.2、MySQL备份

为什么备份：

- 保证重要的数据不丢失
- 数据转移

MySQL数据库备份的方式

- 直接拷贝物理文件
- 在naviCat 这种可视化工具中手动导出
- 使用命令行导出 mysqldump 命令行使用

```sql
-- 导出
-- mysqldump -h 主机 -u 用户  -p 密码 数据库 表名 > 物理磁盘位置/文件名
mysqldump -hlocalhost -uroot -pchj0526 test app_user >D:/a.sql

-- mysqldump -h 主机 -u 用户  -p 密码 数据库 表名1 表名2 > 物理磁盘位置/文件名
mysqldump -hlocalhost -uroot -pchj0526 test app_user app_user1 >D:/a.sql

-- mysqldump -h 主机 -u 用户  -p 密码 数据库> 物理磁盘位置/文件名
mysqldump -hlocalhost -uroot -pchj0526 test >D:/a.sql


-- 导入
-- 登录的情况下，切换到指定的数据库
-- source 备份文件
source d:/a.sql

-- 没有登陆的情况下
-- mysql -u用户名 -p密码 库名<备份文件
-- mysql -h 主机 -u 用户 -p 密码 库名 < 物理磁盘位置/文件名
mysql -hhlocalhost -uroot -pchj0526 test <D:/a.sql
```

# 9、规范数据库设计

当数据库比较复杂的时候，我们需要设计



**糟糕的数据库设计：**

- 数据冗余，浪费空间
- 数据库插入和删除都会麻烦、异常【屏蔽使用物理外键】
- 程序的性能差

**良好的数据库设计：**

- 节省内存空间
- 保证数据库的完整性
- 方便我们开发系统

**软件开发中，关于数据库的设计**

- 分析需求：分析业务和需要处理的数据库的需求
- 概要设计：设计关系图E-R图

**设计数据库的步骤：**（例：博客）

- 收集信息，分析需求
  - 用户表（用户登录注销，用户的个人信息，写博客，创建分类）
  - 分类表（文章分类，谁创建的）
  - 评论表
  - 友链表（友情链接）
  - 自定义表（系统信息，某个关键字，或者一些主字段）key：value
  - 配置表
  - 字典表
- 标识实体（把需求落地到每个字段）
- 标识实体之间的关系
  - 写博客：user --->   blog
  - 创建分类：user ---->  category
  - 关注：  user ----> user
  - 友链：links
  - 评论：user ----> user ---->blog

## 9.2、三大范式

**为什么需要数据规范化？**

- 信息重复
- 更新异常
- 插入异常
  - 无法正常显示信息
- 删除异常
  - 丢失有效的信息

> 三大范式

**第一范式（1NF）**

​			原子性：保证每一列不可再分

**第二范式（2NF）**

​			前提：满足第一范式

​			每张表只描述一件事情

**第三范式（3NF）**

​			前提：满足第一范式和第二范式

​			确保数据表中的每一列数据都和主键直接相关，而不能间接相关



**规范性  和  性能 问题**

关联查询的表不得超过三张表

- 考虑商业化的需求和目标，（成本，用户体验！） 数据库的性能更加重要
- 在规范性能的问题的时候，需要适当的考虑一下规范性！
- 故意给某些表增加一些冗余的字段（从多表查询中变为单表查询）
- 故意增加一些计算列（从大数据量降低为小数据量的查询：索引）



# 10、JDBC

## 10.1、数据库驱动

驱动：声卡，显卡，数据库

SUN公司为了简化开发人员的（对数据库的统一）操作，提供了一个（java操作数据库的）规范，俗称JDBC

这些规范的实现由具体的厂商去做~

对于开发人员来说，我们只需要掌握JDBC接口的操作即可！

java.sql

javax.sql

还需要导入一个数据库驱动包 mysql-connector-java-x.x.xx.jar



## 10.2、第一个JDBC程序

> 创建测试数据库

1、创建一个普通项目

2、导入数据库驱动

- 新建lib目录 拷贝jar包
- 右键lib文件   Add   as Library.... 

3、编写测试代码

```java
public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.用户信息和url
        String url = "jdbc:mysql://115.159.191.57:3306/zln?useSSL=true&amp&useUnicode=true&amp&characterEncoding=UTF-8&amp&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "chj0526";
        //3.连接成功 数据库对象 Connection代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        //4.执行sql的对象
        Statement statement = connection.createStatement();

        //5.执行sql的对象 去执行sql
        String sql = "select * from user";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("pwd=" + resultSet.getObject("pwd"));
        }
        //6.释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
```

步骤总结

- 加载驱动
- 连接数据库 DriverManager
- 获得执行sql的对象  statement
- 获得返回的结果集
- 释放链接



> DriverManager

```java
//DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
Class.forName("com.mysql.cj.jdbc.Driver");

Connection connection = DriverManager.getConnection(url, username, password);
// connection 代表数据库
//数据库设置自动提交
//事务提交
//事务回滚
connection.rollback();
connection.commit();
connection.setAutoCommit();

```



> URL

```java
        String url = "jdbc:mysql://115.159.191.57:3306/zln?useSSL=true&amp&useUnicode=true&amp&characterEncoding=UTF-8&amp&serverTimezone=GMT%2B8";

jdbc:mysql://主机地址:端口号/数据库名？参数1&参数2
```



> statement 执行sql的对象   prepareStatement 执行sql的对象

```java
statement.executeQuery(); //查询操作返回ResultSet
statement.execute(); //执行任何sql
statement.executeUpdate(); //更新、插入、删除、都是用这个。返回一个受影响的行数
```



> ResultSet 查询的结果集：封装了所有的查询结果

获得指定的数据类型

```java
resultSet.getObject(); //在不知道列类型的情况下使用
resultSet.getString(); //如果知道列的类型就使用指定的类型
......
```

遍历

```java
resultSet.afterLast();//移动到最后面
resultSet.beforeFirst();//移动到最前面
resultSet.next();//移动到下一个
resultSet.previous();//移动到前一行
resultSet.absolute(row);//移动到指定行
```

> 释放资源

```java
resultSet.close();
statement.close();
connection.close();
```



## 10.3、statement对象

jdbc中的statement对象用于数据库发送sql语句，想完成对数据库的增删改查，只需要通过这个对象向数据库发生增删改查语句即可

Statement对象executeUpdate方法，用于向数据库发生增、删、改的sql语句，executeUpdate执行完后，将会返回一个整数（即增删改语句导致了数据库几行数据发生了变化）



Statement.executeQuery方法用于向数据库发送查询语句，executeQuery方法返回代表查询结果的ResultSet对象

> CURD操作 -create

使用executeUpdate(String sql) 方法完成数据添加操作，示例操作

```java
Statement st = conn.createStatement();
String sql = "insert into user(...) values (...)";
int num = st.executeUpdate(sql);
if(num > 0){
    System.out.println("插入成功！！！");
}
    
```

> CURD操作 -delete

使用executeUpdate(String sql) 方法完成数据删除操作，示例操作

```java
Statement st = conn.createStatement();
String sql = "delete from user where 1=1";
int num = st.executeUpdate(sql);
if(num > 0){
    System.out.println("删除成功！！！");
}
    
```

> CURD操作 -update

使用executeUpdate(String sql) 方法完成数据修改操作，示例操作

```java
Statement st = conn.createStatement();
String sql = "update user set name = '' where name = '' ";
int num = st.executeUpdate(sql);
if(num > 0){
    System.out.println("修改成功！！！");
}
    
```



> CURD操作 -read

使用executeQuery(String sql)方法完成数据库查询操作，示例操作

```java
Statement st = conn.createStatement();
String sql = "select * from user";
ResultSet rs = st.executeQuery(sql);
while(rs.next()){
    //根据获取列的数据类型，分别调用rs的相应方法映射到java对象中
}
    
```





> 代码实现

- 提前工具类

```java
public class JdbcUtils {
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    static {
        try{
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            //1.驱动只用加载一次
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取链接
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }


    //释放资源
    private static void release(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if (connection != null) {
            connection.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
    }

    public static void SqlQuery(String sql) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("pwd=" + resultSet.getObject("pwd"));
        }
            release(connection,statement,resultSet);
    }

    public static Integer SqlUpdate(String sql) throws SQLException {
        int i ;
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        i = statement.executeUpdate(sql);
        release(connection,statement,null);
        return i;

    }
}
```

测试

```java
public static void main(String[] args) throws SQLException {
       JdbcUtils.SqlQuery("select * from user");
       JdbcUtils.SqlUpdate("insert into user (name,pwd)values('111','222')");
    }
```



> SQL注入的问题

sql存在漏洞，会被攻击导致数据泄露  sql会被拼接

```sql
SELECT * FROM `user` where name = 'chj' and pwd = '123'
SELECT * FROM `user` where name = '' or 1#' and pwd = '123'
```



## 10.4、PreparedStatement对象

PreparedStatement可以防止sql注入。效率更好！

utils

```java
public class JdbcUtils {
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    static {
        try{
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            //1.驱动只用加载一次
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取链接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }


    //释放资源
    public static void release(Connection connection, Statement statement, ResultSet resultSet) {
        try{
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void SqlQuery(String sql) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("pwd=" + resultSet.getObject("pwd"));
        }
            release(connection,statement,resultSet);
    }

    public static Integer SqlUpdate(String sql) throws SQLException {
        int i ;
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        i = statement.executeUpdate(sql);
        release(connection,statement,null);
        return i;

    }
}

```

测试

```java
增删改
public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into user (`name`,`pwd`)values(?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1,"123");
            st.setString(2,"456");
            //st.setDate(3,new java.sql.Date(new java.util.Date().getTime()));
            int i = st.executeUpdate();
            if (i>0) {
                System.out.println("插入成功");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,null);
        }

    }


查询
    Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from user where id = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1,1);
            rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("pwd"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,rs);
        }

```

## 10.5、事务

要么都成功，要么都失败

> ACID原则

原子性：要么都成功，要么都失败

一致性：总数不变

隔离性：多个进程互不干扰

持久性：一旦提交不可逆，持久化到数据库



隔离性的问题：

脏读：一个事务读取了另一个没有提交的事务

不可重复读：在同一个事务内，重复读取表中的数据，表数据发生了改变

虚度（幻读）：在一个事务内，读取到了别人插入的数据，导致前后读出来的结果不一致



> 代码实现

- 开启事务 conn.setAutoCommit(false);
- 一组业务执行完毕，提交事务
- 可以在catch语句中显示的定义回滚语句，但默认失败就会回滚

```java
 public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            //关闭数据库的自动提交，自动会开启事务
            conn.setAutoCommit(false);//开启事务

            String sql1 = "update account set money = money-100  where name = 'A';";
            st = conn.prepareStatement(sql1);
            st.executeUpdate();

            String sql2 = "update account set money = money+100  where name = 'B';";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();
            int i = 1/0;
            //业务完毕，提交事务
            conn.commit();
            System.out.println("成功");

        } catch (SQLException throwables) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("失败");
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,null);
        }
    }
```

## 10.6、数据库连接池

数据库连接-------执行完毕--------释放

连接----释放 十分浪费系统资源

**池化技术：准备一些预先的资源，过来就连接预先准备好的**

编写连接池，实现一个接口DataSource



> 开源数据源实现

DBCP

C3P0

Druid：阿里巴巴

使用了这些数据库连接池后，我们在项目开发中就不需要编写连接数据库的代码了！
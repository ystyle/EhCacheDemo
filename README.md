EhCacheDemo
===========


简单的Ehcache 缓存集群测试Demo

使用JGroups或RMI方式配置，多机器时不用手工配置多文件

同一局域网如有多台缓存服务器会自动发现与连接

[参考文档](https://github.com/ystyle/EhCacheDemo/blob/master/%E5%8F%82%E8%80%83%E6%96%87%E6%A1%A3.txt)

配置详解:
>Groups配置方式:[ehcache-jgroups.xml](https://github.com/ystyle/EhCacheDemo/blob/master/src/main/resources/ehcache-jgroups.xml)

>RMI配置文式:[ehcache-rmi.xml](https://github.com/ystyle/EhCacheDemo/blob/master/src/main/resources/ehcache-rmi.xml)

>普通手工配置(不推荐使用):[ehcache-default.xml](https://github.com/ystyle/EhCacheDemo/blob/master/src/main/resources/ehcache-default.xml)、[ehcache-default2.xml](https://github.com/ystyle/EhCacheDemo/blob/master/src/main/resources/ehcache-default2.xml)

例子：
>下载本项目后,该例子使用 *Groups* 配置方式

>导入 _maven_ 项目, 更新所有的依赖, 

>如果有更改配置方式请看: _[tk.ystyle.Main](https://github.com/ystyle/EhCacheDemo/blob/master/src/main/java/tk/ystyle/Main.java#L30)_ 39行 


JAR依赖详情请看 **pom.xml**
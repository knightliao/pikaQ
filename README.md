PikaQ
=======

可靠的消息系统

![http://ww1.sinaimg.cn/bmiddle/60c9620fjw1eozsd1u8fuj205k06a3z3.jpg](http://ww1.sinaimg.cn/bmiddle/60c9620fjw1eozsd1u8fuj205k06a3z3.jpg)

**主要目标：**

- 支持可靠消息系统：解决消息队列与本地事务的分布式事务统一
- 解决部分分布式事务一致性问题：默认事务发生后一定成功的条件下，保证事务一致性，无法支持分布式事务回滚
- 可靠、简单、统一、通用

**适用于：**

- 想通过消息队列作为各个系统的传输中间件，并达到分布式事务一致性
- 要求消息系统是可靠的，不丢数据，不重复处理数据
- 消息发生后，默认业务一定会成功，若失败需要不断重试

**不适用于：**

- 不支持回滚式的分布式事务一致性：消息发生后，如果分布式的部分事务失败，无法将整个分布式事务回滚

注：为了使PikaQ亦能解决整个分布式事务自动回滚，可以让发生事务回滚的服务发送回滚消息给发送方让其进行回滚来解决。

### 项目信息 ###

- Java项目(1.6+)
- Maven管理(3.0.5+)

pikaQ.git branches and Maven version:

- dev(develop branch): 0.0.1-SNAPSHOT
- master(stable branch)：0.0.1-SNAPSHOT
- [更新日志](https://github.com/knightliao/pikaQ/wiki/updates) 

### pikaq-client 使用 ###

在您的 Maven POM 文件里加入：

    <dependency>
        <groupId>com.baidu.pikaq</groupId>
        <artifactId>pikaq-client</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>

### Tutorials ###

- [Tutorial 1 可靠消息组件使用](https://github.com/knightliao/pikaQ/wiki/Tutorial1)

### 联系与赞助作者

[https://github.com/knightliao/pikaQ/wiki/sponsor](https://github.com/knightliao/pikaQ/wiki/sponsor)

### 群·联系·讨论

- java技术QQ群：68373211
- 我的微信：knightliao
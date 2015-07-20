
###操作步骤

#### 新建数据库

1. 新建数据库。执行sql: pikaq-web-demo/sql/pikaq-web-demo.sql
2. 新建pikaq表：执行sql: pikaq-client/sql/pikaq.sql

#### 新建 rabbit MQ数据：exchange 和 router-key 、 Queue

Q的拓扑图：

    pikaQWebDemoExchange -----(logMessageInfo.info)----> pikaQWebDemoLogMessageQueue
    pikaQWebDemoExchange -----(logMessageInfo.info2)----> pikaQWebDemoLogMessageQueue2

### 业务场景模拟

#### 模拟京东购物扣款行为

上游：每隔一段时间就购买订单

下游：每隔一段时间就进行扣款

##### 不使用pikaq的情况

- 发送消息后，本地事务未能提交，从而导致：扣款了，但是订单未成交

##### 使用pikaq

- 发送消息后，本地事务未能提交，保证：未扣款，订单未提交

### 环境

- java: 1.7
- spring: 3.1.2.RELEASE
- spring amqp: 1.4.5.RELEASE



###操作步骤

#### 新建数据库

1. 新建数据库。执行sql: pikaq-web-demo/sql/pikaq-web-demo.sql
2. 新建pikaq表：执行sql: pikaq-client/sql/pikaq.sql

#### 新建 rabbit MQ数据：exchange 和 router-key 、 Queue

Q的拓扑图：

    pikaQWebDemoExchange -----(logMessageInfo.info)----> pikaQWebDemoLogMessageQueue
    pikaQWebDemoExchange -----(logMessageInfo.info2)----> pikaQWebDemoLogMessageQueue2
    pikaQWebDemoExchange -----(logMessageInfo.error)----> pikaQWebDemoLogMessageQueueConsumerError 

### 业务场景模拟：模拟京东购物扣款行为

#### 场景一：上游：提交订单，发送消息后，本地事务发生异常

##### 使用原生 rabbitmq : 出错

- http://127.0.0.1:8080/home/addCampaignConsumerErrorNormalRabbitMQ   消息发送成功，但是本地事务未能提交

##### 使用 pikaq 弱一致性 : 正确

- http://127.0.0.1:8080/home/addCampaignConsumerErrorPikaQNormal   未扣款，订单未提交

##### 使用 pikaq 强一致性 : 正确

- http://127.0.0.1:8080/home/addCampaignConsumerErrorPikaQStrong   未扣款，订单未提交

### 环境

- java: 1.7
- spring: 3.1.2.RELEASE
- spring amqp: 1.4.5.RELEASE


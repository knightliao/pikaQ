
### 介绍

一个简单的 rabbitmq demo 示例

#### 业务场景

模拟京东购物扣款行为

上游：每隔一段时间就购买订单

下游：每隔一段时间就进行扣款

#### 不使用pikaq的情况

有可能出现重复订单的情况，有可能出现重复捐款

#### 使用pikaq

pikaQ保证：不会重复购买订单，不会重复捐款

### rabbitmq 帐号

- host:port: 127.0.0.1:5672
- user: pikaq
- password: pikaq

### 环境

- java: 1.7
- spring: 3.1.2.RELEASE
- spring amqp: 1.4.5.RELEASE
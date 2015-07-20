
操作步骤

### 新建数据库

1. 新建数据库。执行sql: pikaq-web-demo/sql/pikaq-web-demo.sql
2. 新建pikaq表：执行sql: pikaq-client/sql/pikaq.sql

### 新建 rabbit MQ数据：exchange 和 router-key 、 Queue

Q的拓扑图：

    pikaQWebDemoExchange -----(logMessageInfo.info)----> pikaQWebDemoLogMessageQueue
    pikaQWebDemoExchange -----(logMessageInfo.info2)----> pikaQWebDemoLogMessageQueue2
    
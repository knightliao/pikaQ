package com.baidu.pikaq.client.test.mock;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.pikaq.client.producer.gateway.impl.PikaQGatewayDefaultImpl;

/**
 * Created by knightliao on 15/7/2.
 */
public class PikaQGatewayMockImpl extends PikaQGatewayDefaultImpl {

    protected final Logger LOGGER = LoggerFactory.getLogger(PikaQGatewayMockImpl.class);

    // monitor blocking queue
    protected static BlockingQueue<MockObject> blockingQueue = new LinkedBlockingQueue();

    /**
     * 正常的情况
     *
     * @param routeKey
     * @param correlation
     * @param data
     */
    @Override
    protected void sendRabbitQ(final String routeKey, final String correlation, final Object data) {
        MockObject mockObject = new MockObject(correlation, data);

        blockingQueue.add(mockObject);
    }

    /**
     * 拿数据
     *
     * @return
     */
    public static MockObject consumeOne() {

        return blockingQueue.poll();
    }
}

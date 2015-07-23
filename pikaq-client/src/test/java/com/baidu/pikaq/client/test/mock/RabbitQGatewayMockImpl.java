package com.baidu.pikaq.client.test.mock;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.pikaq.client.producer.gateway.impl.RabbitQGatewayDefaultImpl;

/**
 * Created by knightliao on 15/7/2.
 */
public class RabbitQGatewayMockImpl extends RabbitQGatewayDefaultImpl {

    // monitor blocking queue
    private static BlockingQueue<MockObject> blockingQueue = new LinkedBlockingQueue();

    protected final Logger LOGGER = LoggerFactory.getLogger(RabbitQGatewayMockImpl.class);

    /**
     * @param exchange
     * @param routeKey
     * @param data
     */
    @Override
    public void send(String exchange, String routeKey, Object data) {

        //
        final String correlation;
        correlation = UUID.randomUUID().toString();

        MockObject mockObject = new MockObject(correlation, data);

        blockingQueue.add(mockObject);
    }

    public static Object consumeOne() {

        MockObject mockObject = blockingQueue.poll();
        if (mockObject != null) {
            return mockObject.getObject();
        } else {
            return null;
        }
    }
}

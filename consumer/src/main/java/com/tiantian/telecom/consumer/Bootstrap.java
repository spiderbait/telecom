package com.tiantian.telecom.consumer;

import com.tiantian.common.bean.Consumer;
import com.tiantian.telecom.consumer.bean.CalllogConsumer;

import java.io.IOException;

/**
 * start consumer
 */

public class Bootstrap {
    public static void main(String[] args) throws IOException {
        // use kafka consumer to acquire flume data and store data into HBase
        Consumer consumer = new CalllogConsumer();

        consumer.consume();

        consumer.close();

    }
}

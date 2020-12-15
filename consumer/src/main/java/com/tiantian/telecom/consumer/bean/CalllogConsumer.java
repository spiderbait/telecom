package com.tiantian.telecom.consumer.bean;

import com.tiantian.common.bean.Consumer;
import com.tiantian.common.constant.Names;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.protocol.types.Field;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class CalllogConsumer implements Consumer {

    public void consume() {

        try {
            // create config object
            Properties prop = new Properties();
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("consumer.properties"));
            System.out.println(prop.getProperty("bootstrap.servers"));

            // acquire flume data
            KafkaConsumer<String, String> consumer = new KafkaConsumer<>(prop);
            System.out.println("Flume data received.");

            // subscribe topic
            consumer.subscribe(Arrays.asList(Names.TOPIC.getValue()));
            System.out.println("Topic: " + Names.TOPIC.getValue());

            int batchIndex = 0;
            // consume data
            while(true) {
                ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(10000));
                System.out.println("Batch " + batchIndex + " count -> " + consumerRecords.count());
                for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                    System.out.println("Data: " + consumerRecord.value());
                }
                batchIndex ++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() throws IOException {

    }
}

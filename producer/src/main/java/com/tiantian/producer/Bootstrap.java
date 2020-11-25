package com.tiantian.producer;

import com.tiantian.common.bean.Producer;
import com.tiantian.producer.bean.LocalFileProducer;
import com.tiantian.producer.io.LocalFileDataIn;
import com.tiantian.producer.io.LocalFileDataOut;

public class Bootstrap {
    public static void main(String[] args) throws Exception{

        Producer producer = new LocalFileProducer();
        producer.setIn(new LocalFileDataIn("E:\\Projects\\Java\\telecom\\doc\\contact.log"));
        producer.setOut(new LocalFileDataOut("E:\\Projects\\Java\\telecom\\doc\\call.log"));

        producer.produce();
        producer.close();

    }
}

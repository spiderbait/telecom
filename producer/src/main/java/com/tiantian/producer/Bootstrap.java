package com.tiantian.producer;

import com.tiantian.common.bean.Producer;
import com.tiantian.producer.bean.LocalFileProducer;
import com.tiantian.producer.io.LocalFileDataIn;
import com.tiantian.producer.io.LocalFileDataOut;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Bootstrap {
    public static void main(String[] args) throws Exception{

        if (args == null || args.length < 2) {
            System.out.println("ARGS ERROR!\n" +
                    "USAGE: java -jar produce.jar [input] [output]");
            System.exit(1);
        }

        Producer producer = new LocalFileProducer();

//        /Users/tianzhuoli/IdeaProjects/telecom/doc/contact.log
//        /Users/tianzhuoli/IdeaProjects/telecom/doc/call.log
        producer.setIn(new LocalFileDataIn(args[0]));
        producer.setOut(new LocalFileDataOut(args[1]));

        producer.produce();
        producer.close();


    }
}

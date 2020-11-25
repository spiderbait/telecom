package com.tiantian.producer.bean;

import com.tiantian.common.bean.DataIn;
import com.tiantian.common.bean.DataOut;
import com.tiantian.common.bean.Producer;

import java.io.IOException;
import java.util.List;

public class LocalFileProducer implements Producer {

    private DataIn in;
    private  DataOut out;
    private volatile boolean flg = true;

    public void setIn(DataIn in) {
        this.in = in;
    }

    public void setOut(DataOut out) {
        this.out = out;
    }

    public void produce() throws IOException {

        List<Contact> contacts = in.read(Contact.class);
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
//        while(flg) {
//            
//        }
    }

    public void close() throws IOException {
        if (in != null) {
            in.close();
        }

        if (out != null) {
            out.close();
        }
    }
}

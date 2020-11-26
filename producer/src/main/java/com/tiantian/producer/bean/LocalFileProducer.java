package com.tiantian.producer.bean;

import com.tiantian.common.bean.CallLog;
import com.tiantian.common.bean.DataIn;
import com.tiantian.common.bean.DataOut;
import com.tiantian.common.bean.Producer;
import com.tiantian.common.util.DateUtil;
import com.tiantian.common.util.NumberUtil;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
        while(flg) {
            try {
                Math.random();
                int oCallIndex = new Random().nextInt(contacts.size());
                int tCallIndex;
                while (true) {
                    tCallIndex = new Random().nextInt(contacts.size());
                    if (oCallIndex != tCallIndex) {
                        break;
                    }
                }

                // generate two random phone numbers
                Contact oCall = contacts.get(oCallIndex);
                Contact tCall = contacts.get(tCallIndex);

                // generate random call duration
                String duration = NumberUtil.format(new Random().nextInt(3000), 4);
    //            String durationString = "" + duration;
    //            for (int i =0; i < 4 - durationString.length(); i++) {
    //               durationString += "0";
    //                durationString = "0" + durationString;
    //            }
                // generate random call start time
                String startTS = "20200101000000";
                String endTS = "20210101000000";

                // call time
                long startTime = DateUtil.parse(startTS, "yyyyMMddHHmmss").getTime();
                long endTime = DateUtil.parse(endTS, "yyyyMMddHHmmss").getTime();

                long callTime = startTime + (long)((endTime - startTime) * Math.random());

                String callTimeString = DateUtil.format(new Date(callTime),
                        "yyyyMMddHHmmss");
                // call log
                CallLog log = new CallLog(oCall.getTel(), tCall.getTel(),
                        callTimeString, duration);
                // write to file
                System.out.println(log);
                out.write(log);

                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
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

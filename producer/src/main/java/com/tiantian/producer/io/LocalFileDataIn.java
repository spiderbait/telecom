package com.tiantian.producer.io;

import com.tiantian.common.bean.Data;
import com.tiantian.common.bean.DataIn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LocalFileDataIn implements DataIn {

    private BufferedReader reader = null;

    public LocalFileDataIn(String path) {
        setPath(path);
    }

    public void setPath(String path) {
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public Object read() throws IOException {
        return null;
    }

    public <T extends Data> List<T> read(Class<T> clazz) throws IOException {

        List<T> ts = new ArrayList<T>();

        String line = null;
        while ((line = reader.readLine()) != null) {
            try {
                T t = clazz.newInstance();
                t.setValue(line);
                ts.add(t);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }
}

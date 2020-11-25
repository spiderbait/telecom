package com.tiantian.producer.io;

import com.tiantian.common.bean.DataOut;

import java.io.IOException;

public class LocalFileDataOut implements DataOut {

    public LocalFileDataOut(String path) {
        setPath(path);
    }

    public void setPath(String path) {

    }

    public void close() throws IOException {

    }
}

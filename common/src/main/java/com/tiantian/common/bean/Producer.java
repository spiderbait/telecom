package com.tiantian.common.bean;

import java.io.Closeable;
import java.io.IOException;

public interface Producer extends Closeable {

    public void setIn(DataIn in);
    public void setOut(DataOut out);

    public void produce() throws IOException;
}

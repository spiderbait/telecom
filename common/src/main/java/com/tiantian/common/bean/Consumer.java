package com.tiantian.common.bean;

import java.io.Closeable;

/**
 * consumer interface
 */


public interface Consumer extends Closeable {

    public void consume();

}

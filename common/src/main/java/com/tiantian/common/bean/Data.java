package com.tiantian.common.bean;

public abstract class Data implements Val{

    public String content;

    public Object getValue() {
        return content;
    }

    public void setValue(Object val) {
        content = (String) val;
    }
}

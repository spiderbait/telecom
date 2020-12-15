package com.tiantian.common.constant;

import com.tiantian.common.bean.Val;



public enum Names implements Val {
    NAMESPACE("telecom"),
    TOPIC("telecom");

    private String namespace;

    private Names(String namespace) {
        this.namespace = namespace;
    }

    public String getValue() {
        return namespace;
    }

    public void setValue(Object val) {
        this.namespace = (String) val;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}

package com.tiantian.common.constant;

import com.tiantian.common.bean.Val;



public enum Names implements Val {
    NAMESPACE("telecom");

    private String namespace;

    private Names(String namespace) {
        this.namespace = namespace;
    }

    public Object getValue() {
        return null;
    }

    public void setValue(Object val) {
        this.namespace = (String) val;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}

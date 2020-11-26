package com.tiantian.common.bean;

public class CallLog {
    private String oCall;
    private String tCall;
    private String callTime;
    private String duration;

    public CallLog(String oCall, String tCall, String callTime, String duration) {
        this.oCall = oCall;
        this.tCall = tCall;
        this.callTime = callTime;
        this.duration = duration;
    }

    public String getoCall() {
        return oCall;
    }

    public void setoCall(String oCall) {
        this.oCall = oCall;
    }

    public String gettCall() {
        return tCall;
    }

    public void settCall(String tCall) {
        this.tCall = tCall;
    }

    public String getCallTime() {
        return callTime;
    }

    public void setCallTime(String callTime) {
        this.callTime = callTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return oCall + "\t" + tCall + "\t" + callTime + "\t" + duration;
    }
}

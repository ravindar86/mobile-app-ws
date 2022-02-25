package com.app.rest.mobileappws.response;

import java.util.Date;

public class ErrorMessage {
    private Date date;
    private String msg;
    private String occurredAt;

    public ErrorMessage() {
    }

    public ErrorMessage(Date date, String msg, String occurredAt) {
        this.date = date;
        this.msg = msg;
        this.occurredAt = occurredAt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(String occurredAt) {
        this.occurredAt = occurredAt;
    }
}

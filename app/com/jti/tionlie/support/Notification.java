package com.jti.tionlie.support;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by User on 1/19/2016.
 */
public class Notification implements Serializable{
    private String field;
    private String message;
    private String type;
    private Date time;

    public Notification(String message, String type) {
        this.message = message;
        this.type = type;
        this.time=new Date();
    }

    public Notification(String field, String message, String type) {
        this(message,type);
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

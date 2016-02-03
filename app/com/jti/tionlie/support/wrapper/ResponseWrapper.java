package com.jti.tionlie.support.wrapper;

import com.jti.tionlie.support.AppConstans;
import com.jti.tionlie.support.Notification;

import java.util.List;

/**
 * Created by User on 1/19/2016.
 */
public class ResponseWrapper<T> {
    private final String apiVersion= AppConstans.API_VERSION;

    private List<Notification> notifications;
    private T data;

    public ResponseWrapper() {
    }

    public ResponseWrapper(T data) {
        this.data = data;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

package com.liu.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by liuneng on 2016/12/28.
 */
public class QueryEvent extends ApplicationEvent {
    private String message;

    public QueryEvent(Object source) {
        super(source);
    }

    public String getMessage() {
        return message;
    }

    public QueryEvent setMessage(String message) {
        this.message = message;
        return this;
    }
}

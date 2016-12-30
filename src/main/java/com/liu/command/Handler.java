package com.liu.command;

/**
 * Created by liuneng on 2016/12/28.
 */
public interface Handler {
    void handle(Command command);

    String getCmdName();

    String getDescription();
}

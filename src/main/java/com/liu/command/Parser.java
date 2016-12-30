package com.liu.command;

/**
 * Created by liuneng on 2016/12/28.
 */
public interface Parser {
    Command parse(String[] cmd);
    boolean hasOption(String option);
}

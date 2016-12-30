package com.liu.command;

import javafx.util.Pair;

import java.util.List;
import java.util.Map;

/**
 * Created by liuneng on 2016/12/28.
 */
public class Command{
    protected String cmdName;
    protected Map<String, String> args;
    protected String description;

    public String getDescription() {
        return description;
    }

    public Command setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCmdName() {
        return cmdName;
    }

    public Command setCmdName(String cmdName) {
        this.cmdName = cmdName;
        return this;
    }

    public Map<String, String> getArgs() {
        return args;
    }

    public Command setArgs(Map<String, String> args) {
        this.args = args;
        return this;
    }
}

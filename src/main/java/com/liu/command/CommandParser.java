package com.liu.command;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by liuneng on 2016/12/28.
 */
public class CommandParser {
    private Map<String,Parser> parserMap;

    public CommandParser setParserMap(Map<String, Parser> parserMap) {
        this.parserMap = parserMap;
        return this;
    }

    public Command parse(String cmd) {
        String[] args = cmd.split("\\s+");
        if (parserMap.get(args[0]) == null) {
            throw new IllegalArgumentException(args[0]+"命令不存在");
        }
        return parserMap.get(args[0]).parse(args);
    }
}

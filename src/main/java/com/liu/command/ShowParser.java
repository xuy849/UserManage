package com.liu.command;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by liuneng on 2016/12/28.
 */
@Component
public class ShowParser implements Parser {
    public static final String F = "-f";
    public static final String L = "-l";
    private static final Set<String> options = new HashSet();

    static {
        options.add(F);
        options.add(L);
    }

    public Command parse(String[] cmd) {
        ShowCommand command = new ShowCommand();
        Map<String, String> args = new HashMap<>();
        for (int i = 1; i < cmd.length; i = i + 2) {
            if (!hasOption(cmd[i])) {
                throw new IllegalArgumentException(cmd[i] + "选项不存在");
            }
            args.put(cmd[i], cmd[i + 1]);
        }
        command.setArgs(args);
        return command;
    }

    @Override
    public boolean hasOption(String option) {
        return options.contains(option);
    }
}

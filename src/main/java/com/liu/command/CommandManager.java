package com.liu.command;

import com.sun.corba.se.impl.activation.CommandHandler;
import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by liuneng on 2016/12/28.
 */
public class CommandManager {
    private Map<String, Handler> commands;
    private CommandParser commandParser;

    public CommandManager setCommands(Map<String, Handler> commands) {
        this.commands = commands;
        return this;
    }

    @Autowired
    public CommandManager setCommandParser(CommandParser commandParser) {
        this.commandParser = commandParser;
        return this;
    }

    public void showMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
        for (String cmd : commands.keySet()){
            menu.append(String.format("\\\\command:%s     description:%s\\\\\n",cmd,commands.get(cmd).getDescription()));
        }
        menu.append("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\nsho");
        System.out.println(menu);
    }

    public void handle(String cmd) {
        Command command = commandParser.parse(cmd);
        commands.get(command.getCmdName()).handle(command);
    }
}

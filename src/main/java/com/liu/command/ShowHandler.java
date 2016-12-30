package com.liu.command;

import com.liu.dto.User;
import com.liu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * Created by liuneng on 2016/12/28.
 */
@Component
public class ShowHandler implements Handler {
    public static String cmdName = "show";
    public static String description = "查询用户";
    @Autowired
    private UserService userService;

    @Override
    public void handle(Command command) {
        Map<String,String> args = command.getArgs();
        User user = new User();
        user.setFirstName(args.get(ShowParser.F)).setLastName(args.get(ShowParser.L)).setLastUpdatedTime(new Date());
        System.out.println(userService.query(user));
    }

    @Override
    public String getCmdName() {
        return cmdName;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

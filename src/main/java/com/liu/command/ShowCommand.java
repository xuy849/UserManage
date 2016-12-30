package com.liu.command;

import com.liu.dto.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by liuneng on 2016/12/28.
 */
public class ShowCommand extends Command {

    public ShowCommand() {
        cmdName = "show";
        description = "查询用户信息";
    }
}

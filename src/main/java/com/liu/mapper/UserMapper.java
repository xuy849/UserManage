package com.liu.mapper;

import com.liu.dto.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by liuneng on 2016/12/28.
 */
public interface UserMapper extends BaseMapper<User,Integer> {
    User getByFirstNameAndLastName(@Param("firstName") String firstName,@Param("lastName") String lastName);
}

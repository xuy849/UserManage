package com.liu.validator;

import com.liu.dto.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

/**
 * Created by liuneng on 2016/12/28.
 */
@Component("userValidator")
public class UserValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return aClass == User.class;
    }

    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (((User) o).getFirstName() == null) {
            errors.rejectValue("firstName","firstName为空");
        }
        if (((User) o).getLastName() == null) {
            errors.rejectValue("lastName", "lastName为空");
        }
    }
}
